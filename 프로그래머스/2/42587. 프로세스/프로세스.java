import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Deque<int[]> process= new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<priorities.length; i++){
            process.add(new int[] {priorities[i], i});
            pq.add(priorities[i]);
        }
        
        int answer = 0;
        int index = -1;
        
        for(int i=0; i<priorities.length; i++){
            int max = pq.poll();
            while(true){
                int now[] = process.poll();
                if(now[0] == max){
                    index = now[1];
                    answer ++;
                    break;
                }else{
                    process.add(new int[]{now[0], now[1]});
                }
            }
            if(index == location) break;
        }
        
        return answer;
    }
}