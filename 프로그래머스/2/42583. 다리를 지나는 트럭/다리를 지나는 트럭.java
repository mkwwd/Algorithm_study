import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<int[]> onBridge = new ArrayDeque<>();
        
        int total_weight = 0;
        int time = 1;
        
        for(int truck : truck_weights){
            
            if(!onBridge.isEmpty() && onBridge.peek()[1] <= time){
                total_weight -= onBridge.poll()[0];
            }
            
            while(total_weight + truck > weight || onBridge.size() >= bridge_length){
                int out[] = onBridge.poll();
                total_weight -= out[0];
                time = out[1];
            }
            
            total_weight += truck;
            
            onBridge.add(new int[] {truck, time + bridge_length});
            time++;
            
        }
        
        return onBridge.peekLast()[1];
    }
}