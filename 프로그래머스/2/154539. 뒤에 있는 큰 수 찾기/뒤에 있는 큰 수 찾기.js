function solution(numbers) {
    
    const que = [];
    const answer = Array(numbers.length).fill(0);
    
    for(let i=numbers.length-1; i>=0; i--){
        while(que.length){
            if(que[que.length-1] <= numbers[i]) que.pop();
            else break;
        }
        if(que.length){
            answer[i] = que[que.length-1]
        }else answer[i] = -1
        que.push(numbers[i])
    }
  
    return answer;
}