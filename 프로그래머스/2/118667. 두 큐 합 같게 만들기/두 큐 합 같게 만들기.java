import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        Deque<Integer> que1 = new ArrayDeque<>();
        Deque<Integer> que2 = new ArrayDeque<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i=0; i<queue1.length; i++){
            que1.add(queue1[i]);
            que2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        if(sum1 == sum2) return 0;
        
        int size = queue1.length * 3;
        int cnt = 0;
        
        while(cnt <= size && !que1.isEmpty() && !que2.isEmpty()){
        
            if(sum1 > sum2){
                int poll = que1.pollFirst();
                que2.add(poll);
                sum1 -= poll;
                sum2 += poll;
            }else{
                int poll = que2.pollFirst();
                que1.add(poll);
                sum1 += poll;
                sum2 -= poll;
            }
            
            cnt++;
            if(sum1 == sum2) return cnt;
            
        }
        
        return -1;
    }
}