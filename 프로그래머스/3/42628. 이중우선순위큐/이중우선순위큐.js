function solution(operations) {
    var answer = [];
    let que = [];
    
    for(let i=0; i<operations.length; i++){
        if(operations[i].charAt(0) == 'I'){
            que.push(operations[i].slice(2)*1);
        }else if(operations[i] == "D 1"){
            que.pop();
        }else{
            que.shift();
        }
        
        que.sort((a,b)=>a-b);
    }
    
    answer = que.length? [que[que.length-1],que[0]] : [0, 0];
    
    return answer;
}