function solution(players, callings) {
    
    const run = new Map();
    const num = new Map();
    
    for(let i=0; i<players.length; i++){
        run.set(players[i], i+1);
        num.set(i+1, players[i]);
    }
    
    for(let i=0; i<callings.length; i++){
        var now = run.get(callings[i]);
        var pre = now-1;
        var preName = num.get(pre);
        run.set(callings[i], pre);
        run.set(preName, now);
        num.set(pre, callings[i]);
        num.set(now, preName);
    }
    
    var answer = [];
    
    for(let i=0; i<num.size; i++){
        answer.push(num.get(i+1));
    }
    
    return answer;
}