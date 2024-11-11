import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Deque<int[]> que = new ArrayDeque<>();
        Deque<Integer> end = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++){
            que.add(new int[] {progresses[i], speeds[i]});
        }
        
        while(!que.isEmpty()){
            
            int size = que.size();
            int finish = 0;
            for(int i=0; i<size; i++){
                int now[] = que.poll();
                int sum = now[0] + now[1];
                que.add(new int[] {sum, now[1]});
            }
            
            for(int i=0; i<size; i++){
                int now[] = que.peek();
                if(now[0] >= 100){
                    que.poll();
                    finish++;
                }else{
                    break;
                }
            }
            
            
            if(finish != 0){
                end.add(finish);
            }
            
        }
        
        int size = end.size();
        int[] answer = new int[size];
        
        for(int i=0; i<size; i++){
            answer[i] = end.poll();
        }
        
        return answer;
    }
}