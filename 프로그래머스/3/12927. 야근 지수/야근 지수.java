import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        
        while(n > 0 && !pq.isEmpty()){
            if(!pq.isEmpty()){
                int a = pq.poll();
                a--;
                n--;
                if(a != 0) pq.add(a);
            }
        }
        
        long answer = 0;
        
        while(!pq.isEmpty()){
            int now = pq.poll();
            answer += now*now;
        }
        
        return answer;
    }
}