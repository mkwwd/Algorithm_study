class Solution {
    public int solution(int[][] matrix_sizes) {
        
        int n = matrix_sizes.length;
        
        int dp[][] = new int[n][n];
        
        for(int len = 2; len<=n; len++){
            for(int i=0; i + len-1 < n; i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int cost = dp[i][k] + dp[k+1][j] + matrix_sizes[i][0] * matrix_sizes[k][1] * matrix_sizes[j][1];
                    dp[i][j] = Math.min(cost, dp[i][j]);
                }
            }
        }
        
        return dp[0][n-1];
    }
}