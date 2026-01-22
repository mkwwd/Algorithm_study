class Solution {
    public int solution(int n, int[] money) {
        
        long dp[] = new long[n+1];
        dp[0] = 1;
        
        for(int i=0; i<money.length; i++){
            int now = money[i];
            for(int j=now; j<=n; j++){
                dp[j] += dp[j-now];
                dp[j] %= 1000000007;
            }
        }
        
        return (int)dp[n];
    }
}