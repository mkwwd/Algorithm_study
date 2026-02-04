import java.util.*;

class Solution {
    public int solution(int[] cards) {
        
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int card : cards){
            
            int now = card;
            int len = 0;
            
            while(!visited.contains(now)){
                visited.add(now);
                len++;
                now = cards[now-1];
            }
            
            pq.add(len);
            
        }
        
        return pq.poll()*pq.peek();
    }
}