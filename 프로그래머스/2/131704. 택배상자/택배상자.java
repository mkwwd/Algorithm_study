import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        Deque<Integer> belt = new ArrayDeque<>();
        Deque<Integer> sub = new ArrayDeque<>();
        
        for(int i=1; i<=order.length; i++){
            belt.add(i);
        }
        
        int cnt = 0;
        boolean run = true;
        
        while(cnt < order.length && run){
            
            int size = belt.size();
            boolean find = false;

            for(int i=0; i<size; i++){
                if(belt.peek() < order[cnt]){
                    sub.add(belt.poll());
                }else if(belt.peek() == order[cnt]){
                    belt.poll();
                    find = true;
                    break;
                }else break;
            }
            
            //
            if(find){
                cnt++;
            }else{
                if(sub.peekLast() == order[cnt]){
                    sub.pollLast();
                    cnt++;
                }else{
                    run = false;
                }
            }
                
        }
        
        return cnt;
    }
}