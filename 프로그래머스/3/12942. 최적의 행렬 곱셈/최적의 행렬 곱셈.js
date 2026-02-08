function solution(matrix_sizes) {
    
    var n = matrix_sizes.length;
    const dp = Array.from({length :n}, () => Array(n).fill(0));

    for(let len = 2; len<=n; len++){
        for(let i=0; i+len-1<n; i++){
            let j = i+len-1;
            dp[i][j] = Number.MAX_SAFE_INTEGER;
            for(let k=i; k<j; k++){
                let sum = dp[i][k] + dp[k+1][j] + matrix_sizes[i][0] * matrix_sizes[k][1] * matrix_sizes[j][1]
                dp[i][j] = Math.min(sum, dp[i][j]);
            }
        }
    }

    return dp[0][n-1];
}