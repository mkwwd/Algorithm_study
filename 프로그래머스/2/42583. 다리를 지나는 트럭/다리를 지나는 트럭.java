import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<int[]> bridge = new ArrayDeque<>();
        int time = 1;
        int sum = 0;
        
        for(int truck : truck_weights){
            while(sum + truck > weight || bridge.size() >= bridge_length){
                int out[] = bridge.poll();
                sum -= out[0];
                time = out[1];
            }
            
            bridge.add(new int[]{truck, time++ +bridge_length});
            sum += truck; 
            
            if(time >= bridge.peek()[1]){
                sum -= bridge.poll()[0];
            }
        }
        
        return bridge.peekLast()[1];
    }
}