import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> run = new HashMap<>();
        HashMap<Integer, String> num = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            run.put(players[i], i+1);
            num.put(i+1, players[i]);
        }
        
        for(int i=0; i<callings.length; i++){
            int now = run.get(callings[i]);
            int pre = now-1;
            String preName = num.get(pre);
            run.put(callings[i], pre);
            run.put(preName, now);
            num.put(pre, callings[i]);
            num.put(now, preName);
        }
        
        String[] answer = new String[players.length];
        
        for(int i=1; i<num.size()+1; i++){
            answer[i-1] = num.get(i);
        }
        
        return answer;
    }
}