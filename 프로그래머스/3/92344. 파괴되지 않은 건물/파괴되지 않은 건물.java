class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int n = board.length;
        int m = board[0].length;
        int[][] prefix = new int[n+1][m+1];

        for(int[] s : skill){
            int degree = s[0] == 1 ? -s[5] : s[5];
            int st1 = s[1], ed1 = s[2], st2 = s[3], ed2 = s[4];
            
            prefix[st1][ed1] += degree;
            prefix[st1][ed2+1] -= degree;
            prefix[st2+1][ed1] -= degree;
            prefix[st2+1][ed2+1] += degree;
        }
        
        for(int i=0; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                prefix[i][j] += prefix[i][j-1];
            }
        }
        
        for(int j=0; j<m+1; j++){
            for(int i=1; i<n+1; i++){
                prefix[i][j] += prefix[i-1][j];
            }
        }
        
        int cnt = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] += prefix[i][j];
                if(board[i][j] > 0) cnt++;
            }
        }
        
        return cnt;
    }
    
}