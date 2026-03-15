import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int answer = 0;
        int st = 1;
        int range = w*2+1;
        
        for(int i=0; i<stations.length; i++){
            int rangeLeft = stations[i] - w -1;
            int len = rangeLeft - st + 1;
            if(len > 0){
                answer += Math.ceil((double)len/range);
            }
            st = stations[i] + w + 1;
        }
        
        if(st < n){
            int len = n-st;
            answer += Math.ceil((double)len/range);
        }else if(st == n){
            answer += 1;
        }
        
        return answer;
    }
}