import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> sco = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            sco.add(scoville[i]);
        }
        
        int cnt = 0;
        
        while(sco.peek() < K && sco.size() > 1){
            int one = sco.poll();
            int two = sco.poll();
            sco.add(one + two*2);
            cnt++;
        }
        
        if(sco.peek() < K){
            return -1;
        }else{
            return cnt;
        }
        
    }
}