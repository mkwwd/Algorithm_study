function solution(s){
    
    var que = [];
    var answer = true;
    
    for(let i=0; i<s.length; i++){
        if(s.charAt(i) == ')' && que.length && que[que.length-1] == '('){
            que.pop();
            continue;
        }
        que.push(s.charAt(i));
    }
    
    if(que.length) answer = false;

    return answer;
}