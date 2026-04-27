import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        int cnt = 0;
        
        while(pq.peek() < K && pq.size() > 1){
            int one = pq.poll();
            int two = pq.poll();
            pq.add(one + two *2);
            cnt++;
        }
        
        if(pq.peek() >= K){
            return cnt;
        }else return -1;
        
    }
}