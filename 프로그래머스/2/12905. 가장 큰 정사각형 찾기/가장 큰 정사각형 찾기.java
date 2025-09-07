class Solution
{
    
    public int solution(int [][]board)
    {
        
        int W = board.length;
        int H = board[0].length;
        int answer = 0;
        int dp[][] = new int[W][H];
        
        for(int i=0; i<W; i++){
            for(int j=0; j<H; j++){
               if(board[i][j] == 1){
                   if(i ==0 || j ==0){
                       dp[i][j] = 1;
                   }else{
                       dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                   }
               }
                
                answer = Math.max(answer, dp[i][j]);
            }
        }                      
        
        return answer*answer;
    }
    
        
}