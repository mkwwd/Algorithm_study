import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
    
        Arrays.sort(rocks);
        int min = 1;
        int max = distance;
        int answer = 0;
        
        while(min <= max){
            
            int mid = (min+max)/2;
            int dis = 0;
            int start = 0;
            int cnt = 0;
            
            for(int i=0; i<rocks.length; i++){
                dis += rocks[i] - start;
                if(dis < mid){
                    cnt++;
                }else{
                    dis = 0;                
                }
                start = rocks[i];
            }
            
            if(dis + distance - start < mid) cnt++;
            
            if(cnt > n){
                max = mid - 1;
            }else{
                answer = mid;
                min = mid+1;
            }
            
        } 
        
        return answer;
    }
}