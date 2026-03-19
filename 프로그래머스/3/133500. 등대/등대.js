function solution(n, lighthouse) {
    
    const node = Array.from({length:n+1}, () => [])
    const degree = Array(n+1).fill(0)

    for(const [a,b] of lighthouse){
        node[a].push(b)
        node[b].push(a)
        degree[a]++
        degree[b]++
    }

    const que = []

    for(let i=1;i<=n;i++){
        if(degree[i] === 1) que.push(i)
    }

    const visited = Array(n+1).fill(false);
    let answer = 0
    
    while(que.length){
        const now = que.shift();
        if(visited[now]) continue;
        for(const next of node[now]){
            if(visited[next]) continue;
            visited[next] = true;
            answer ++;
            for(const nn of node[next]){
                degree[nn] --;
                if(degree[nn] == 1){
                    que.push(nn);
                }
            }
        }
    }
    
    
    return answer;
}