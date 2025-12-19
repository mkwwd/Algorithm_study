import java.util.*;

class Solution {
    
    static int board[];
    static int answer = 0;
    
    public int solution(int n) {
        
        board = new int[n];
        
        nQueen(n, 0);
        
        return answer;
    }
    
    public void nQueen(int n, int row){
        
        if(row == n){
            answer++;
            return;
        }
        
        for(int i=0; i<n; i++){
            board[row] = i;
            
            if(isPossible(row)){
                nQueen(n, row+1);
            }
        }
    }

    public boolean isPossible(int row){

        for(int i=0; i<row; i++){
            // 가로나 세로가 같을 때
            if(board[i] == board[row]) return false;
            // 기울기가 같을 때
            if(Math.abs(row - i) == Math.abs(board[row] - board[i])) return false;
        }
        
        return true;
    }
}