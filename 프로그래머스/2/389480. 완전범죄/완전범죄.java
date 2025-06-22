import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        
        int len = info.length;
        
        boolean dp[][][] = new boolean[len+1][n][m];
        dp[0][0][0] = true;
        
        for(int k=0; k<len; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(!dp[k][i][j]) continue;
                    
                    int aSum = info[k][0];
                    int bSum = info[k][1];
                    
                    if(i + aSum < n) {
                        dp[k+1][i+aSum][j] = true;
                    }
                    
                    if(j + bSum < m){
                        dp[k+1][i][j+bSum] = true;
                    }                      
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dp[len][i][j]){
                    min = Math.min(min, i);
                }
            }
        }
        
        if(min == Integer.MAX_VALUE){
            min = -1;
        }
               
        return min;
    }
}