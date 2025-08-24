function solution(maps) {
    
    const dx = [0, -1, 0, 1]
    const dy = [1, 0, -1, 0]
    
    const que = []
    que.push([0, 0, 1])
    
    const N = maps.length;
    const M = maps[0].length;
    
    const visited = Array.from({length : N }, () => Array(M).fill(false));
    var answer = 0;
    
    while(que.length){
        var now = que.shift();
        for(let i=0; i<4; i++){
            var nextX = now[0] + dx[i]
            var nextY = now[1] + dy[i]
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue
            if(maps[nextX][nextY] == 0) continue
            if(visited[nextX][nextY]) continue
            visited[nextX][nextY] = true
            if(nextX == N-1 && nextY == M-1){
                answer = now[2]+1
                break
            }
            que.push([nextX, nextY, now[2]+1])
        }
    }
    
    if(answer == 0) answer = -1
    
    return answer;
}