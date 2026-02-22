function solution(prices) {
    
    const stack = [];
    const answer = [];
    const len = prices.length;
    
    for(let i=0; i<len; i++){
        while(stack.length && stack[stack.length-1][0] > prices[i]){
            var out = stack.pop();
            answer[out[1]] = i - out[1];
        }
        stack.push([prices[i], i]);
    }
    
    while(stack.length){
        out = stack.pop();
        answer[out[1]] = len-1-out[1];
    }
    
    return answer;
}