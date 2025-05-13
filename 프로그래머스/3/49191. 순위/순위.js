function solution(n, results) {
    
    const player = Array.from({length : n+1}, () => Array(n+1).fill(0));
    
    results.forEach(([win, lose]) => {
        player[win][lose] = 1
    })    
    
    for(let k=1; k<n+1; k++){
        for(let i=1; i<n+1; i++){
            for(let j=1; j<n+1; j++){
                if(player[i][k] == 1 && player[k][j] == 1){
                    player[i][j] = 1
                }
            }
        }
    }
    
    var answer = 0;
    
    for(let i=1; i<n+1; i++){
        let cnt = 0;
        for(let j=1; j<n+1; j++){
            if(player[i][j] == 1 || player[j][i] == 1) cnt++
        }
        if(cnt == n-1) answer ++
    }
    
    return answer;
}