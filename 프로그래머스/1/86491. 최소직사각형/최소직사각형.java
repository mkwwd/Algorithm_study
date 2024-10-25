import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w = 0;
        int h = 0;
        
        for(int i=0; i<sizes.length; i++){
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            sizes[i][0] = max;
            sizes[i][1] = min;   
        }
        
        for(int i=0; i<sizes.length; i++){
            w = Math.max(sizes[i][0], w);
        }
        
        for(int j=0; j<sizes.length; j++){
            h = Math.max(sizes[j][1], h);
        }
            
        
        return w*h;
    }
}