function solution(n) {
    
    const rule = ["4", "1", "2"]
    var answer = '';
    
    while(n > 0){
        let div = n%3;
        answer = rule[div] + answer;
        n = Math.floor(n/3);
        if(div == 0) n--;
    }
    
    return answer;
}