import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long min = 0;
        long max = 0;
        
        for(int i=0; i<times.length; i++){
            max = Math.max(max, times[i]);
        }
        
        max *= n;
        
        long answer = 0;
        
        while(min <= max){
            
            long mid = (min + max)/2;
            long cnt = 0;
            
            for(int i=0; i<times.length; i++){
                cnt += mid/times[i];
            }
            
            if(cnt >= n) {
                answer = mid;
                max = mid -1;
            }else{
                min = mid + 1;
            }
            
        }
       
        return answer;
    }

}