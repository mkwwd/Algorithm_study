var N, M, mapInfo, visited;
const dx = [0, -1, 0, 1];
const dy = [1, 0, -1, 0];


function solution(maps) {
    
    N = maps.length;
    M = maps[0].length;
    
    mapInfo = Array.from({length : N}, () => Array(M).fill(0));
    visited = Array.from({length : N}, () => Array(M).fill(false));
    
    for(let i=0; i<N; i++){
        for(let j=0; j<M; j++){
            if(maps[i].charAt(j) == 'X')continue;
            mapInfo[i][j] = maps[i].charAt(j) - '0';
        }
    }
        
    var answer = [];
    
    for(let i=0; i<N; i++){
        for(let j=0; j<M; j++){
            if(mapInfo[i][j] > 0 && !visited[i][j]){
                //console.log(i+" "+j)
                var sum = bfs(i , j);
                answer.push(sum);
            }
        }
    }
    
    if(answer.length == 0) return [-1]
    
    answer.sort((a,b) => a-b);
    
    return answer;
}

function bfs(x, y){
    
    const que = [];
    visited[x][y] = true;
    que.push([x, y]);
    var sum = mapInfo[x][y];
    
    while(que.length){
        var now = que.pop();
        for(let i=0; i<4; i++){
            var nextX = now[0] + dx[i];
            var nextY = now[1] + dy[i];
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
            if(visited[nextX][nextY]) continue;
            if(mapInfo[nextX][nextY] == 0) continue;
            visited[nextX][nextY] = true;
            sum += mapInfo[nextX][nextY];
            que.push([nextX, nextY]);
        }
    }
    
    return sum;
    
}