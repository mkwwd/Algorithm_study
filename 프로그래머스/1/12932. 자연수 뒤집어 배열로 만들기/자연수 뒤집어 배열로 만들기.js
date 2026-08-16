function solution(n) {
    
    var answer = [];
    
    while(n > 0){
        var div = n%10;
        answer.push(div);
        n = Math.floor(n/10);
    }
    
    return answer;
}