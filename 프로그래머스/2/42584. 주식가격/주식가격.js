function solution(prices) {
    var stack = [];
    var answer = [];

    for(let i=0; i<prices.length; i++){
        while(stack.length > 0){
            if(stack[stack.length-1][0] > prices[i]){
                const index = stack[stack.length-1][1];
                answer[index] = i - index;
                stack.pop();
            }else break;
        }
        stack.push([prices[i], i])
    }
    
    while(stack.length > 0){
        const index = stack[stack.length-1][1];
        answer[index] = prices.length - index -1;
        stack.pop();
    }
    
    return answer;
}