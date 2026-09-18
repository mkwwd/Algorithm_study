import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int maxW = 0;
        int maxH = 0;
        
        for(int i=0; i<sizes.length; i++){
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            maxW = Math.max(max, maxW);
            maxH = Math.max(min, maxH);
        }
        
        return maxW*maxH;
    }
}