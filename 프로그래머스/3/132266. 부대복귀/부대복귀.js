function solution(n, roads, sources, destination) {
    
    const roadInfo = {};
    
    for(let i=0; i<roads.length; i++){
        var from = roads[i][0];
        var to = roads[i][1];
        if(!roadInfo[from]) roadInfo[from] = [];
        if(!roadInfo[to]) roadInfo[to] = [];
        roadInfo[from].push(to);
        roadInfo[to].push(from);
    }
    
    const min = Array(n+1).fill(Number.MAX_SAFE_INTEGER);
    const pq = [];
    
    min[destination] = 0;
    pq.push([destination, 0]);
    let head = 0;
    
    while(head < pq.length){
      
        var now = pq[head++];
        if(min[now[0]] < now[1]) continue;
        for(let next of roadInfo[now[0]]){
            if(now[1] + 1 <= min[next]){
                pq.push([next, now[1]+1]);
                min[next] = now[1]+1;
            }
        }
    }
    
    var answer = Array(sources.length).fill(0);
    
    for(let i=0; i<answer.length; i++){
        if(min[sources[i]] == Number.MAX_SAFE_INTEGER){
            answer[i] = -1;
        }else{
            answer[i] = min[sources[i]];
        }
    }
    
    return answer;
}