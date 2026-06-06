function solution(N, road, K) {
    
    const roadInfo = Array.from({length: N+1}, () => []);
    
    road.forEach((info) => {
        roadInfo[info[0]].push([info[1], info[2]]);
        roadInfo[info[1]].push([info[0], info[2]]);
    })
    
    const minTime = Array(N+1).fill(Number.MAX_SAFE_INTEGER);
    minTime[1] = 0;
    const que = [[1,0]];
    
    while(que.length){
        var now = que.pop();
        if(minTime[now[0]] < now[1]) continue;
        for(let next of roadInfo[now[0]]){
            var sum = now[1] + next[1];
            if(minTime[next[0]] >= sum){
                minTime[next[0]] = sum;
                que.push([next[0], sum]);
            }
        }
    }
    
    var answer = 0;
    
    for(let i=1; i<=N; i++){
        if(minTime[i] <= K) answer++;
    }

    return answer;
}