var answer = 0;
var board;

function solution(n) {
    
    board = Array(n).fill(0);
    
    nQueen(n, 0);
    
    return answer;
}

function nQueen(n, row){
    
    if(row == n) {
        answer++;
        return;
    }
    
    for(let i=0; i<n; i++){
        board[row] = i;
        if(isPossible(row)){
            nQueen(n, row+1);
        }
    }
    
}

function isPossible(row){
    
    for(let i=0; i<row; i++){
        if(board[i] == board[row]) return false;
        if(Math.abs(row - i) == Math.abs(board[row]-board[i])) return false;
    }
    
    return true;
    
}
    