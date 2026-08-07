import java.util.*;

class Solution {
    public long solution(long n) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        while(n > 0){
            long div = n%10;
            n /= 10;
            pq.add(div);
        }
        
        long answer = 0;
        
        while(pq.size() > 0){
            answer += pq.poll();
            if(pq.size() > 0) answer *= 10;
        }
        
        return answer;
    }
}