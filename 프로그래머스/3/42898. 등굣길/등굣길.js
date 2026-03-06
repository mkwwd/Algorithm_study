function solution(m, n, puddles) {
    
    const map = Array.from({length : n+1}, () => Array(m+1).fill(0));
    
    puddles.forEach((x) => {
        map[x[1]][x[0]] = -1;
    })
    
    map[1][1] = 1;
    
    for(let i=1; i<= n; i++){
        for(let j=1; j<=m; j++){
            if(map[i][j] == -1) continue
            if(map[i-1][j] > 0) map[i][j] += map[i-1][j]%1000000007
            if(map[i][j-1] > 0) map[i][j] += map[i][j-1]%1000000007
            map[i][j] %= 1000000007
        }
    }
    
    
    return map[n][m];
}