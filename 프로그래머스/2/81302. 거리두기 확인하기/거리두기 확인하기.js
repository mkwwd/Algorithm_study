const dx = [0, -1, 0, 1]
const dy = [1, 0, -1, 0]

function solution(places) {
    
    var answer = Array(5).fill(0);
    
    for(let i=0; i<5; i++){
        var wRoom = Array.from({length : 5}, ()=> Array(5).fill(0))
        for(let j=0; j<5;j++){
            wRoom[j] = places[i][j].split("");
        }
        var isPoss = checkDis(wRoom);
        if(isPoss) answer[i] = 1;
    }
    
    return answer;
}

function checkDis(wRoom){
    
    for(let i=0; i<5; i++){
        for(let j=0; j<5; j++){
            if(wRoom[i][j] == "P"){
                const que = [];
                que.push([i, j, 0]);
                const visited = Array.from({length : 5}, () => Array(5).fill(false));
                visited[i][j] = true;
                while(que.length){
                    var now = que.shift();
                    if(now[2] >= 2) continue;
                    for(let k=0; k<4; k++){
                        var nextX = now[0] + dx[k];
                        var nextY = now[1] + dy[k];
                        if(nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) continue;
                        if(visited[nextX][nextY]) continue;
                        visited[nextX][nextY] = true;
                        if(wRoom[nextX][nextY] == "X") continue;
                        if(wRoom[nextX][nextY] == "P" && now[2] + 1 <= 2){
                            return false;
                        }
                        que.push([nextX, nextY, now[2]+1])
                    }
                }
            }
        }
    }
    
    return true;
}