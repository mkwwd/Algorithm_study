function solution(n) {
    
    const pq = [];
    
    while(n > 0){
        var div = n%10;
        pq.push(div);
        n = Math.floor(n/10);
    }
    
    pq.sort((a,b) => a-b);
    
    var answer = 0;
    
    while(pq.length){
        answer += pq.pop();
        if(pq.length) answer *= 10;
    }
    
    return answer;
}