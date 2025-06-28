function solution(begin, end) {
    
    const len  = end - begin + 1;
    var answer = [];
    
    for(let i=0; i<len; i++){
        var ans = find(begin + i);
        answer.push(ans);
    }
    
    return answer;
}

function find(number){
    
    if(number == 1) return 0;
    let max = 1;
    for(let i=2; i*i <= number; i++){
        if(number%i == 0) {
            max = i
            if(number/i <= 1e7) return number/i;
        }
    }
    return max
}