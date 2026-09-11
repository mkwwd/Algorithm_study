function solution(n) {
    
    const word = ["4", "1", "2"]
    var answer = '';
    
    while(n > 0){
        let mod = n%3;
        answer = word[mod] + answer;
        n = Math.floor(n/3);
        if(mod == 0) n--;
    }
    
    return answer;
}