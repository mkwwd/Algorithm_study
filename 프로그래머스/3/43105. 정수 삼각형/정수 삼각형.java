import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int n = triangle.length;
        int dp[] = new int[n];
 
        for(int i=0; i<n; i++){
            dp[i] = triangle[n-1][i];
        }
        
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[j] = triangle[i][j] + Math.max(dp[j], dp[j+1]);
            }
        }
        
        int answer = 0;
        
        for(int i=0; i<n; i++){
            answer = Math.max(answer, dp[i]);
        }
        
        return answer;
            
    }
}