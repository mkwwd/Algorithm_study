import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int map[][] = new int[n+1][m+1];
        boolean isPuddle[][] = new boolean[n+1][m+1];
        
        for(int i=0; i<puddles.length; i++){
            isPuddle[puddles[i][1]][puddles[i][0]] = true;
        }
        
        map[1][1] = 1;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(isPuddle[i][j]) continue;
                map[i][j] += map[i-1][j]+map[i][j-1];
                map[i][j] %= 1000000007;
            }
        }
       
        return map[n][m];
            
    }
}