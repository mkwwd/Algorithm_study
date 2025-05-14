function solution(number, k) {
    
    const stack = []
    var size = k
    
    for(let i=0; i<number.length; i++){
        while(stack.length > 0 && stack[stack.length-1] < number.charAt(i)-'0' && k>0){
            stack.pop()
            k--
        }
        stack.push(number.charAt(i) - '0')
    }
    
    var answer = "";
    for(let i=0; i<number.length - size; i++){
        answer = answer + stack[i]
    }
    
    return answer;
}