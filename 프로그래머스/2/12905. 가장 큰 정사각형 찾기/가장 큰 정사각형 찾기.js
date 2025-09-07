function solution(board)
{
    var W = board.length;
    var H = board[0].length;
    var answer = 0;
    const dp = Array.from({length : W}, () => Array(H).fill(0));
    
    for(let i=0; i<W; i++){
        for(let j=0; j<H; j++){
            if(board[i][j] == 1){
                if(i == 0 || j == 0){
                    dp[i][j] = 1
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1])+1
                }
            }
            answer = Math.max(answer, dp[i][j])
        }
    }

    return answer*answer;
}