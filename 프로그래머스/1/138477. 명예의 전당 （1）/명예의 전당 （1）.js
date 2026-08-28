function solution(k, score) {    
    
    var que = [];
    var answer = [];
    
    for(let i=0; i<score.length; i++){
        if(que.length < k){
            que.push(score[i]);
        }else{
            if(que[que.length-1] < score[i]){
                que.pop();
                que.push(score[i]);
            }
        }
        que.sort((a,b) => b-a);
        answer.push(que[que.length-1]);
    }
  
    return answer;
}