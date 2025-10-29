import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        Deque<Integer> server = new ArrayDeque<>();
        int answer = 0;
        
        for(int i=0; i<players.length; i++){
            while(!server.isEmpty() && server.peek() < i){
                server.poll();
            }
            int need = players[i]/m;
            if(server.size() >= need) continue;
            int plus = need - server.size();
            for(int j=0; j<plus; j++){
                server.add(i+k-1);
                answer++;
            }
        }
    
        return answer;
    }
}