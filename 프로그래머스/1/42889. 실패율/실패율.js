function solution(N, stages) {
    
    var round = Array(N+2).fill(0);
    
    for(let i=0; i<stages.length; i++){
        round[stages[i]]++;
    }
    
    var percent = [];
    var player = stages.length;
    
    for(let i=1; i<N+1; i++){
        percent.push([round[i]/player, i]);
        player -= round[i];
    }
    
    percent.sort((a,b) => {
        if(a[0] == b[0]) return a[1]-b[1];
        return b[0]-a[0];
    })
    
    var answer = [];
    
    for(let i=0; i<percent.length; i++){
        answer.push(percent[i][1]);
    }

    return answer;
}