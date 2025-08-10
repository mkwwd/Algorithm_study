import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for(int i=0; i<enemy.length; i++){
            if(pq.size() < k){
                pq.add(enemy[i]);
                answer++;
                continue;
            }
            // 비교해서 집어넣기
            // 더 작고 막을 수 있으면 막기
            if(pq.peek() < enemy[i] && pq.peek() <= n){
                pq.add(enemy[i]);
                n -= pq.poll();
                answer++;
                continue;
            }
            // 더 작지 않으면 막을 수 있는지 확인
            if(enemy[i] <= n){
                n -= enemy[i];
                answer++;
            }else break;
  
        }
        
        
        
        return answer;
    }
}