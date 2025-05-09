function solution(triangle) {
    
    const len = triangle.length;
    const dp = [...triangle[len -1]];
    
    for(let i=len-2; i>=0; i--){
        for(let j=0; j<=i; j++){
            dp[j] = triangle[i][j] + Math.max(dp[j], dp[j+1]);
        }
    }
    
    return dp[0];
}