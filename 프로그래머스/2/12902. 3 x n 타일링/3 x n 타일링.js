function solution(n) {
    
    const dp = Array(n+1).fill(0);
    
    dp[2] = 3;
    var sum = 0;

    for(let i=4; i<n+1; i+=2){
        dp[i] = dp[i-2]*3 + sum*2 + 2;
        if(dp[i] > 1000000007) dp[i] %= 1000000007;
        sum += dp[i-2];
    }
    
    return dp[n];
}