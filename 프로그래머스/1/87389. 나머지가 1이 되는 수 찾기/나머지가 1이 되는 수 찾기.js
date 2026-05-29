function solution(n) {
    
    var answer = find(n-1);
    
    return answer;
}

function find(n){
    
    for(let i=2; i<=Math.sqrt(n); i++){
        if(n%i == 0) return i;
    }
    
    return n;
        
}