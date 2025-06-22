var miro;
var N, M;
var dx = [0, 1, 0, -1], dy = [1, 0, -1, 0];

function solution(maps) {
    
    miro = Array.from({length : maps.length}, () => Array(maps[0].length).fill(""));
    N = maps.length;
    M = maps[0].length;
    const point = Array.from({length : 3}, () => Array(2).fill(0));
    
    for(let i=0; i<N; i++){
        for(let j=0; j<M; j++){
            miro[i][j] = maps[i].charAt(j);
            if(maps[i].charAt(j) == "S"){
                point[0][0] = i;
                point[0][1] = j;
            }else if(maps[i].charAt(j) == "L"){
                point[1][0] = i;
                point[1][1] = j;
            }else if(maps[i].charAt(j) == "E"){
                point[2][0] = i;
                point[2][1] = j;
            }
        }
    }
    
    var answer1 = find(point[0], point[1])
    var answer2 = find(point[1], point[2])
    var answer = 0;
    
    if(answer1 != 0 && answer2 != 0){
        answer = answer1 + answer2
    }else{
        answer = -1
    }
   
    return answer;
}

function find(st, end){
    
    const visited = Array.from({length : N}, () => Array(M).fill(false));
    const que = new Array()
    que.push([st[0], st[1], 0])
    visited[st[0]][st[1]] = true;
    var cnt = 0;
    
    while(que.length){
        const now = que.shift();
        if(now[0] == end[0] && now[1] == end[1]){
            cnt = now[2]
            break;
        }
        for(let i=0; i<4; i++){
            var nextX = now[0] + dx[i];
            var nextY = now[1] + dy[i];
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
            if(visited[nextX][nextY]) continue;
            if(miro[nextX][nextY] == "X") continue;
            visited[nextX][nextY] = true;
            que.push([nextX, nextY, now[2] + 1])
        }
    }
   return cnt
}