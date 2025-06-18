function solution(N, road, K) {
    
    const village = Array.from({length: N+1}, () => []);
   
    road.forEach((info) => {
        let [a, b, c] = info;
        village[a].push([b, c]);
        village[b].push([a, c]);
    })
    
    const time = Array(N+1).fill(Number.MAX_SAFE_INTEGER)
    const que = [];
    time[1] = 1
    
    que.push([1, 0])
    
    while(que.length){
        const now = que.pop();
        for(let next of village[now[0]]){
            if(time[next[0]] >= next[1] + now[1]){
                time[next[0]] = next[1] + now[1]
                que.push([next[0], next[1] + now[1]])
            }
        }
    }
    
    var answer = 0;
    
    for(let t of time){
        if(t <= K) answer++
    }

    return answer;
}