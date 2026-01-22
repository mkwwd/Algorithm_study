function solution(n, money) {
    
    var dp = Array(n+1).fill(0);
    
    dp[0] = 1;

    for(let i=0; i<money.length; i++){
        var now = money[i];
        for(let j=now; j<n+1; j++){
            dp[j] += dp[j-now];
            dp[j] %= 1000000007;
        }
    }

    return dp[n];
}