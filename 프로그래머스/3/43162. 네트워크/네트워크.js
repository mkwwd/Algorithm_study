var connected = [];

function solution(n, computers) {
   
    var answer = 0;
    connected = Array(n).fill(false);
    
    for(let i=0; i<n; i++){
        if(connected[i]) continue;
        connected[i] = true;
        answer++;
        connect(i, computers);
    }
    
    return answer;
}

function connect(now, computer){
    
    for(let i=0; i<computer.length; i++){
        if(computer[now][i] == 1 && !connected[i]){
            connected[i] = true;
            connect(i, computer);
        }
    }
    
}
    