class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int type[] = {0, -1, 1};
        int N = board.length;
        int M = board[0].length;
        int copy[][] = new int[N+1][M+1];
        
        for(int i=0; i<skill.length; i++){
            int tp = type[skill[i][0]];
            int st1 = skill[i][1];
            int ed1 = skill[i][2];
            int st2 = skill[i][3];
            int ed2 = skill[i][4];
            copy[st1][ed1] += tp * skill[i][5];
            copy[st1][ed2+1] -= tp * skill[i][5];
            copy[st2+1][ed1] -= tp * skill[i][5];
            copy[st2+1][ed2+1] += tp * skill[i][5];
        }
        
        for(int i=0; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                copy[i][j] += copy[i][j-1];
            }
        }
        
        for(int j=0; j<M+1; j++){
            for(int i=1; i<N+1; i++){
                copy[i][j] += copy[i-1][j]; 
            }
        }
        
        int answer = 0;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                board[i][j] += copy[i][j];
                if(board[i][j] > 0) answer ++;
            }
        }
        
        return answer;
    }
    
}