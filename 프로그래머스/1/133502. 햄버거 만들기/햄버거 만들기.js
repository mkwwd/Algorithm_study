function solution(ingredient) {
    
    var stack = [];
    var answer = 0;
    
    for(let i=0; i<ingredient.length; i++){
        stack.push(ingredient[i]);
        var len = stack.length;
        if(len >= 4){
            if(stack[len-1] == 1 && stack[len-2] == 3 && stack[len-3] == 2 && stack[len-4] == 1){
                answer++;
                for(let j=0; j<4; j++){
                    stack.pop();
                }
            }
        }
    }
    
    return answer;
}