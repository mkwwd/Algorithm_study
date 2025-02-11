import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] map = new int[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];
        int div = 1000000007;
        
        for(int i=0; i<puddles.length; i++){
            int x = puddles[i][1];
            int y = puddles[i][0];
            visited[x][y] = true;
        }
        
        map[1][1] = 1;
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(visited[i][j]) continue;
                map[i][j] += map[i][j-1] + map[i-1][j];
                map[i][j] %= div;
            }
        }
        
        return map[n][m];
            
    }
}