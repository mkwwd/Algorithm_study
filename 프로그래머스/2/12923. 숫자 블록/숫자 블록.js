function solution(begin, end) {
    
    const len  = end - begin + 1;
    var answer = [];
    
    for(let i=0; i<len; i++){
        var ans = find(begin + i);
        answer.push(ans);
    }
    
    return answer;
}

function find(num){
    
    if(num == 1) return 0;
    let max = 1;
    for(let i=2; i <= Math.sqrt(num); i++){
        if(num%i == 0) {
            max = i
            let ans = num/max;
            if(ans <= 10000000) return ans;
        }
    }
    return max;
}