function solution(players, m, k) {
    
    const server = [];
    var answer = 0;
    
    for(let i=0; i<players.length; i++){
        while(server.length && server[0] < i){
            server.shift();
        }
        var need = Math.floor(players[i]/m);
        if(server.length >= need) continue;
        var plus = need - server.length;
        for(let j=0; j<plus; j++){
            server.push(i+k-1);
            answer++;
        }
    }
    
    return answer;
}