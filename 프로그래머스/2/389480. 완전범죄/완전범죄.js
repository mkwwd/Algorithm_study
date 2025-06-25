function solution(info, n, m) {
    const len = info.length;
    const dp = Array.from({length : len + 1}, () => Array.from({length : n}, () => Array(m).fill(false)))
    
    dp[0][0][0] = true
    
    for(let k=0; k<len; k++){
        for(let i=0; i<n; i++){
            for(let j=0; j<m; j++){
                
                if(!dp[k][i][j]) continue;
                 
                let aSum = info[k][0]
                let bSum = info[k][1]
                
                if(aSum + i < n){
                    dp[k+1][aSum+i][j] = true;
                }
                
                if(bSum+j < m){
                    dp[k+1][i][bSum+j] = true;
                }
                
            }
        }
    }
                          
    var answer = Number.MAX_SAFE_INTEGER;
    
    for(let i=0; i<n; i++){
        for(let j=0; j<m; j++){
            if(!dp[len][i][j]) continue
            answer = Math.min(answer, i)
        }
    }
    
    if(answer == Number.MAX_SAFE_INTEGER){
        answer = -1
    }
    
    return answer;
}