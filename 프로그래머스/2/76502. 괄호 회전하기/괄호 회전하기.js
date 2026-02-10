function solution(s) {
    
    var answer = 0;
    
    for(let i=0; i<s.length; i++){
        
        const que = [];
        
        for(let j=0; j<s.length; j++){
            if(!que.length){
                que.push(s.charAt(j));
            }else if(s.charAt(j) == '}' && que[que.length-1] == '{'){
                que.pop();
            }else if(s.charAt(j) == ']' && que[que.length-1] == '['){
                que.pop();
            }else if(s.charAt(j) == ')' && que[que.length-1] == '('){
                que.pop();
            }else{
                que.push(s.charAt(j));
            }
        }
        
        if(!que.length) {
            answer++;
        }
        
        s = s.substring(1) + s.substring(0, 1);
    }

    return answer;
}