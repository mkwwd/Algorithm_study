var n;
var m;
var dx = [0, -1, 0 ,1], dy = [1, 0, -1, 0];
var ground;
var visited;
var map = new Map();

function solution(land) {
    
    n = land.length;
    m = land[0].length;
    ground = Array.from({length : n}, () => Array(m).fill(0));
    visited = Array.from({length : n}, () => Array(m).fill(false));
    var index = 1;
    
    for(let i=0; i<n; i++){
        for(let j=0; j<m; j++){
            if(visited[i][j]) continue;
            if(land[i][j] == 0) continue;
            findOil(land, i, j, index);
            index++;
        }
    }
    
    var max = 0;
    
    for(let i=0; i<m; i++){
        var set = new Set();
        for(let j=0; j<n; j++){
            if(ground[j][i] > 0){
                set.add(ground[j][i]);
            }
        }
        var sum = 0;
        
        set.forEach((id) => sum += map.get(id));
        
        max = Math.max(max, sum);
    }
    
    return max;
}

function findOil(land, x, y, index){
    
    const que = [];
    visited[x][y] = true;
    ground[x][y] = index;
    que.push([x, y]);
    var num = 0;
    var sum = 1;
    
    while(num < que.length){
        var now = que[num];
        for(let i=0; i<4; i++){
            var nextX = now[0] + dx[i];
            var nextY = now[1] + dy[i];
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
            if(visited[nextX][nextY]) continue;
            if(land[nextX][nextY] == 0) continue;
            que.push([nextX, nextY]);
            visited[nextX][nextY] = true;
            ground[nextX][nextY] = index;
            sum++
        }
        num++;
    }
    
    map.set(index, sum);
     
}