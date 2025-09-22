function solution(s)
{
    const que = [];
    
    for(let i=0; i<s.length; i++){
        if(que.length && que[que.length-1] == s.charAt(i)){
            que.pop();
        }else que.push(s.charAt(i));
    }
    
    if(que.length){
        return 0;
    }else return 1;

}