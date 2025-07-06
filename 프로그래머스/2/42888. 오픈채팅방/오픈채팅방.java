import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> id = new HashMap<>();
        Deque<String[]> rec = new ArrayDeque<>();
        
        for(int i=0; i<record.length; i++){
            String[] input = record[i].split(" ");
            if(!input[0].equals("Change")){
                rec.add(new String[] {input[0], input[1]});
            }
            
            if(!input[0].equals("Leave")){
                id.put(input[1], input[2]);
            }
        }
        
        String[] answer = new String[rec.size()];
        
        for(int i=0; i<answer.length; i++){
            String output[] = rec.poll();
            if(output[0].equals("Enter")){
                answer[i] = id.get(output[1]) + "님이 들어왔습니다.";
            }else{
                answer[i] = id.get(output[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}