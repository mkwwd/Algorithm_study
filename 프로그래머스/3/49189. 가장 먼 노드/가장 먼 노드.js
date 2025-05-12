function solution(n, edge) {
    
    const node = Array.from({length : n+1}, () => []);
    
    edge.map(([from, to]) => {
        node[from].push(to)
        node[to].push(from)
    })
    
    const que = [1];
    const visited = Array(n+1).fill(false);
    visited[1] = true;
    let size = que.length;
    
    while(que.length > 0){
        size = que.length
        for(let i=0; i<size; i++){
            const now = que.shift()
            for(let next of node[now]){
                if(visited[next]) continue
                visited[next] = true
                que.push(next)
            }
        }
        
    }
    
    
    return size;
}