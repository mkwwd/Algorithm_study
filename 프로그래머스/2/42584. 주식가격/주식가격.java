import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        Deque<int[]> que = new ArrayDeque<>();
        int len = prices.length;
        int answer[] = new int[len];
        
        for(int i=0; i<len; i++){
            while(!que.isEmpty() && que.peekLast()[0] > prices[i]){
                int out[] = que.pollLast();
                answer[out[1]] = i - out[1]; 
            }
            que.add(new int[] {prices[i], i});
        }
        
        while(!que.isEmpty()){
            int out[] = que.pollLast();
            answer[out[1]] = len-1-out[1];
        }
        
        return answer;
    }
}