import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long start = 0;
        long end = Long.MAX_VALUE / 100;
        
        while(end > start){
            long mid = (start + end)/2;
            
            if(isPossible(times, mid, n)){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        
        return start;
    }
    
    public boolean isPossible(int[] times, long time, int n){
        long cnt = 0;
        for(int i=0; i<times.length; i++){
            cnt += time/times[i];
        }
        if(cnt >= n) return true;
        else return false;
    }
}