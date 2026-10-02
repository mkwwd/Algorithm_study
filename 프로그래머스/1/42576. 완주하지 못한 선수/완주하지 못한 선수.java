import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> goal = new HashMap<>();
        
        for(int i=0; i<completion.length; i++){
            goal.put(completion[i], goal.getOrDefault(completion[i], 0) + 1);
        }
        
        String answer = "";
        
        for(int i=0; i<participant.length; i++){
            int cnt = goal.getOrDefault(participant[i], 0);
            if(cnt == 0){
                answer = participant[i];
                break;
            }else{
                goal.put(participant[i], cnt-1);
            }
        }
        
        return answer;
    }
}