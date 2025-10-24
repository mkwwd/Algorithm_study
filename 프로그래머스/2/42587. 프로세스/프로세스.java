import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Deque<int[]> que = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<priorities.length; i++){
            int num = priorities[i];
            que.add(new int[]{num, i});
            pq.add(num);
        }
        
        int answer = 0;
        int cnt = 0;
        
        while(!que.isEmpty()){
            int now[] = que.poll();
            if(pq.peek() == now[0]){
                pq.poll();
                cnt++;
                if(now[1] == location){
                    answer = cnt;
                }
            }else{
                que.add(now);
            }
        }
       
        return answer;
    }
}