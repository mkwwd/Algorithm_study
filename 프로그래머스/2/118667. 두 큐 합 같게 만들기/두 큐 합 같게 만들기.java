import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        Deque<Integer> que1 = new ArrayDeque<>();
        Deque<Integer> que2 = new ArrayDeque<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i=0; i<queue1.length; i++){
            sum1 += queue1[i];
            que1.add(queue1[i]);
            sum2 += queue2[i];
            que2.add(queue2[i]);
        }
        
        if(sum1 == sum2) return 0;
        
        int cnt = 0;
        int size = que1.size()*2+1;
        
        while(cnt <= size && !que1.isEmpty() && !que2.isEmpty()){
            if(sum1 > sum2){
                int out = que1.poll();
                sum1 -= out;
                que2.add(out);
                sum2 += out;
            }else {
                int out = que2.poll();
                sum2 -= out;
                que1.add(out);
                sum1 += out;
            }
            
            cnt++;
            if(sum1 == sum2) return cnt;
        }
        
        
        return -1;
    }
}