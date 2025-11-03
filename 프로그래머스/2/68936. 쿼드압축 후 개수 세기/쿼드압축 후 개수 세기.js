var answer = [0, 0];

function solution(arr) {
    
    var N = arr.length;
    
    var ans = compress(0, 0, N, arr);
    
    if(ans == 0) answer[0] = 1;
    if(ans == 1) answer[1] = 1;
    
    return answer;
}

function compress(x, y, N, arr){
    
    if(N == 1){
        if(arr[x][y] == 1) return 1;
        if(arr[x][y] == 0) return 0;
    }
    
    var cntOne = 0;
    var cntZero = 0;
    
    var dx = [0, 0, Math.floor(N/2), Math.floor(N/2)];
    var dy = [0, Math.floor(N/2), 0, Math.floor(N/2)];
    
    for(let i=0; i<4; i++){
        var cnt = compress(x+dx[i], y+dy[i], Math.floor(N/2), arr);
        if(cnt == 1) cntOne++;
        if(cnt == 0) cntZero++;
    }
    
    if(cntOne == 4) return 1;
    if(cntZero == 4) return 0;
    
    answer[0] += cntZero;
    answer[1] += cntOne;
    
    return -1;
    
}