import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        
        int n = food_times.length;
        List<int[]> list = new ArrayList<>();
        
        for(int i=0; i<food_times.length; i++){
            list.add(new int[]{food_times[i], i+1});
        }
        
        list.sort((a, b) -> a[0]-b[0]);
        
        long prev = 0;
        long remain = n;
        
        for(int i=0; i<n; i++){
            long now = list.get(i)[0];
            long diff = now-prev;
            if(diff != 0){
                long del = diff * remain;
                if(k >= del){
                    k -= del;
                    prev = now;
                }else{
                    List<int[]> rest = list.subList(i, n);
                    rest.sort((a, b) -> a[1] - b[1]);
                    int answer = rest.get((int)(k%remain))[1];
                    return answer;
                }
            }
            remain--;
        }
        
        return -1;
    }
}