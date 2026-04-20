import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        int player[][] = new int[n+1][n+1];
        
        for(int i=0; i<results.length; i++){
            int win = results[i][0];
            int lose = results[i][1];
            player[win][lose] = 1;
        }
        
        for(int k=1; k<n+1; k++){
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){
                    if(player[i][k] == 1 && player[k][j] == 1){
                        player[i][j] = 1;
                    }
                }
            }
        }
        
        int answer = 0;
        
        for(int i=1; i<n+1; i++){
            int cnt = 0;
            for(int j=1; j<n+1; j++){
                if(player[i][j] == 1 || player[j][i] == 1){
                    cnt++;
                }
            }
            if(cnt == n-1) answer++;
        }
        
        return answer;
    }
}