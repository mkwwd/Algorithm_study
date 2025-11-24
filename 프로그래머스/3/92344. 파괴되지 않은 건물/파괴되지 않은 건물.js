function solution(board, skill) {
    
    var type = [0, -1, 1];
    var N = board.length;
    var M = board[0].length;
    var copy = Array.from({length : N+1}, () => Array(M+1).fill(0));
    
    for(let i=0; i<skill.length; i++){
        var tp = type[skill[i][0]];
        var st1 = skill[i][1];
        var ed1 = skill[i][2];
        var st2 = skill[i][3];
        var ed2 = skill[i][4];
        copy[st1][ed1] += tp * skill[i][5];
        copy[st1][ed2+1] -= tp * skill[i][5];
        copy[st2+1][ed1] -= tp * skill[i][5];
        copy[st2+1][ed2+1] += tp * skill[i][5];
    }
    
    for(let i=0; i<N+1; i++){
        for(let j=1; j<M+1; j++){
            copy[i][j] += copy[i][j-1];
        }
    }
    
    for(let j=0; j<M+1; j++){
        for(let i=1; i<N+1; i++){
            copy[i][j] += copy[i-1][j];
        }
    }
    
    var answer = 0;
    
    for(let i=0; i<N; i++){
        for(let j=0; j<M; j++){
            board[i][j] += copy[i][j];
            if(board[i][j] > 0) answer++;
        }
    }
    
    return answer;
}