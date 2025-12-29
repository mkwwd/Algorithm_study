import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        Deque<Integer> belt = new ArrayDeque<>();
        Deque<Integer> temp = new ArrayDeque<>();
        
        for(int i=1; i<= order.length; i++){
            belt.add(i);
        }
        
        int cnt = 0;
        
        while(cnt < order.length){
            
            while(!belt.isEmpty() && order[cnt] > belt.peek()){
                temp.add(belt.poll());
            }
            
            if(!belt.isEmpty() && order[cnt] == belt.peek()){
                cnt++;
                belt.poll();
            }else if(!temp.isEmpty() && order[cnt] == temp. peekLast()){
                cnt++;
                temp.pollLast();
            }else break;
            
            
        }
        
        return cnt;
    }
}