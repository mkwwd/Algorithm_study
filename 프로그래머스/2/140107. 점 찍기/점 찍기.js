function solution(k, d) {
    
    var answer = 0;
    
    for(let i=0; i<=d; i++){
        if(i != 0 && i%k != 0) continue;
        var max = Math.floor(Math.sqrt(Math.pow(d,2)-Math.pow(i,2)));
        answer += Math.floor(max/k);
    }
    
    answer += Math.floor(d/k) + 1;
    
    return answer;
}