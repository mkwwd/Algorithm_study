function solution(n) {
    
    if(n <= 2) return n;
    
    const dp = Array(n+1).fill(0);
    
    dp[1] = 1;
    dp[2] = 2;
    
    for(let i=3; i<n+1; i++){
        dp[i] = (dp[i-2] + dp[i-1]);
        if(dp[i] > 1000000007) dp[i] %= 1000000007;
    }

    return dp[n];
}