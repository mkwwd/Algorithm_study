import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
    
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        int answer = 0;
        
        while(left <= right){
            
            int mid = (left+right)/2;
            int st = 0;
            int dis = 0;
            int cnt = 0;
            
            for(int i=0; i<rocks.length; i++){
                dis += rocks[i]-st;
                if(dis < mid){
                    cnt++;
                }else{
                    dis = 0;
                }
                st = rocks[i];
            }
            
            if(mid > dis + distance - st) cnt++;
            
            if(cnt <= n){
                left = mid+1;
                answer = mid;
            }else{
                right = mid-1;
            }
        }
        
        return answer;
    }
}