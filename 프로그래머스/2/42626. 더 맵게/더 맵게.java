import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        int trial = 0;
        boolean pos = false;
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            que.add(scoville[i]);
        }
        
        while(que.size() > 1){
            if(que.peek() >= K) break;
            int sco1 = que.poll();
            int sco2 = que.poll();
            int mix = sco1 + sco2*2;
            trial++;
            que.add(mix);
        }
        
        if(que.peek() >= K){
            answer = trial;
        }else{
            answer = -1;
        }
        
        return answer;
    }
}