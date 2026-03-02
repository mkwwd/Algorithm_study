import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int n = triangle.length;
        int dp[][] = new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                dp[i][j] = triangle[i][j];
            }
        }
 
        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
                if(j == 0){
                    dp[i][j] += dp[i-1][j];
                }else{
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
        
        int answer = 0;
        
        for(int i=0; i<n; i++){
            answer = Math.max(answer, dp[n-1][i]);
        }
        
        return answer;
            
    }
}