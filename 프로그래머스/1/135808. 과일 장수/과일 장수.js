function solution(k, m, score) {
    
    score.sort((a,b) => a-b);
    
    var min = k;
    
    var answer = 0;
    
    while(score.length >= m){
        for(let i=0; i<m; i++){
            min = Math.min(min, score.pop());
        }
        answer += min*m;
    }
    
    return answer;
}