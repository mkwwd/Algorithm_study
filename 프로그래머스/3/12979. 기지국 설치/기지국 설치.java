import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int st = 0;
        int end = 0;
        int range = w*2 +1;

        for(int i=0; i<stations.length; i++){
            end = stations[i] -1 -w;
            int gap = end - st;
            if(gap > 0){
                answer += Math.ceil((double)gap/range);
            }
            st = stations[i]+w;
        }
        
        if(st < n){
            answer += Math.ceil((double)(n-st)/range);
        }
        
        return answer;
    }
}