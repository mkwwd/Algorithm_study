class Solution {
    public int solution(int n) {
        
        long[] dp = new long[n+1];
        long sum = 0;
        
        dp[2] = 3;
        
        for(int i = 4; i < n+1; i+=2){
            dp[i] = dp[i-2] *3 + sum*2 + 2;
            dp[i] %= 1000000007;
            sum += dp[i-2];
        }
        
        return (int)dp[n];
    }
}