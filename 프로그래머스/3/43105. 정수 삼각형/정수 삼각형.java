import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int h = triangle.length;
        int result[][] = new int[h][h];
        result[0][0] = triangle[0][0];
        
        for(int i=1; i<h; i++){
            for(int j=0; j<=i; j++){
                if(j > 0){
                    result[i][j] = triangle[i][j] + Math.max(result[i-1][j-1], result[i-1][j]);
                }else{
                    result[i][j] = triangle[i][j] + result[i-1][j];
                }
            }
        }
        
        int max = 0;
        
        for(int i=0; i<h; i++){
            max = Math.max(max, result[h-1][i]);
        }
        
        return max;
    }
}