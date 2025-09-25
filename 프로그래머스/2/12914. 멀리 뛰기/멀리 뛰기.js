function solution(n) {
    
    const dp = [];
    
    dp.push(0);
    dp.push(1);
    dp.push(2);
    
    for(let i=3; i<n+1; i++){
        dp.push((dp[i-1]+dp[i-2])%1234567);
    }

    return dp[n];
}