function solution(n) {
    
    const snail = Array.from({length : n+1}, () => Array(n+1).fill(0));
    
    var dirX = [1, 0, -1];
    var dirY = [0, 1, -1];
    var dir = 0;
    var x = 0;
    var y = 0;
    var num = 1;
    
    for(let i=n; i>0; i--){
        for(let j=0; j<i; j++){
            x += dirX[dir];
            y += dirY[dir];
            snail[x][y] = num;
            num++;
        }
        dir = (dir+1)%3;
    }
    
    var answer = [];
    
    for(let i=1; i<n+1; i++){
        for(let j=0; j<i; j++){
            answer.push(snail[i][j]);
        }
    }
    
    return answer;
}