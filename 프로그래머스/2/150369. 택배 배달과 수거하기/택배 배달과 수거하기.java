import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        Deque<Integer> delivery = new ArrayDeque<>();
        Deque<Integer> pickup = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            delivery.add(deliveries[i]);
            pickup.add(pickups[i]);
        }
        
        long answer = 0;
        
        while(!delivery.isEmpty() || !pickup.isEmpty()){
            int del = cap;
            int pic = cap;
            while(!delivery.isEmpty() && delivery.peekLast() == 0){
                delivery.pollLast();
            }
            while(!pickup.isEmpty() && pickup.peekLast() == 0){
                pickup.pollLast();
            }
            int len = Math.max(delivery.size(), pickup.size());
            answer += len*2;
            while(del > 0 && !delivery.isEmpty()){
                int poll = delivery.pollLast();
                if(poll > del){
                    delivery.add(poll-del);
                }
                del -= poll;
            }
            while(pic > 0 && !pickup.isEmpty()){
                int poll = pickup.pollLast();
                if(poll > pic){
                    pickup.add(poll-pic);
                }
                pic -= poll;
            }
        }
        
        return answer;
    }
}