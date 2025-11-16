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
            if(pq.size() == k){
                if(pq.peek() < enemy[i] && n - pq.peek() >= 0){
                    n -= pq.peek();
                    pq.poll();
                    pq.add(enemy[i]);
                    answer++;
                }else if(pq.peek() >= enemy[i] && n - enemy[i] >= 0){
                    n -= enemy[i];
                    answer++;
                }else break;
            }
        }
        
        return answer;
    }
}