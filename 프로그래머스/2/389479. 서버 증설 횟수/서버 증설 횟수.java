import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<players.length; i++){
            while(!pq.isEmpty() && pq.peek() < i){
                pq.poll();
            }
            if(players[i] < m) continue;
            int need = players[i]/m;
            if(pq.size() >= need) continue;
            int add = need-pq.size();
            int finish = i+k-1;
            for(int j=0; j<add; j++){
                pq.add(finish);
                answer++;
            }
        }
    
        return answer;
    }
}