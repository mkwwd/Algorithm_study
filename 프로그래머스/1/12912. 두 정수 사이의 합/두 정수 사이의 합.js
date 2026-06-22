function solution(a, b) {
    
    if(a == b) return a;
    
    let min = Math.min(a, b);
    let max = Math.max(a, b);
    
    var answer = 0;
    
    for(let i=min; i<=max; i++){
        answer += i;
    }
    
    return answer;
}