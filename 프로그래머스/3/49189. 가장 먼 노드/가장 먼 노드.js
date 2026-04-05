function solution(n, edge) {
    
    const node = Array.from({length : n+1}, () => []);
    
    for(let i=0; i<edge.length; i++){
        let from = edge[i][0];
        let to = edge[i][1];
        node[from].push(to);
        node[to].push(from);
    }
    
    const visited = Array(n+1).fill(false);
    visited[1] = true;
    
    const que = [1];
    var size;
    
    while(que.length){
        var size = que.length;
        for(let i=0; i<size; i++){
            var now = que.shift();
            for(let next of node[now]){
                if(visited[next]) continue;
                visited[next] = true;
                que.push(next);
            }
        }
    }
    
    return size;
}