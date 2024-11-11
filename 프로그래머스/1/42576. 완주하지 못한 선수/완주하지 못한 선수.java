import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> finish = new HashMap<>();
        
        for(int i=0; i<completion.length; i++){
            finish.put(completion[i], finish.getOrDefault(completion[i],0)+1);
        }
        
        String answer = "";
        
        for(int i=0; i<participant.length; i++){
            if(finish.getOrDefault(participant[i], 0) == 0){
                answer = participant[i];
                break;
            }else{
                finish.put(participant[i], finish.get(participant[i])-1);
            }
            
        }
        
        return answer;
    }
}