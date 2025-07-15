function solution(x, y, n) {
    var answer = -1;
    var que = [];
    que.push([y, 0])
    
    while(que.length){
        var now = que.shift();
        if(now[0] < x) continue;
        if(now[0] == x){
            answer = now[1];
            break;
        }
        if(now[0]%3 == 0){
            que.push([now[0]/3, now[1]+1])
        }
        if(now[0]%2 == 0){
            que.push([now[0]/2, now[1]+1])
        }
        que.push([now[0]-n, now[1]+1])
    }
    
    return answer;
}