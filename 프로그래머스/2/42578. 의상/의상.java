import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> type = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String tp = clothes[i][1];
            type.put(tp, type.getOrDefault(tp, 0) + 1);
        }
        
        int answer = 1;
        
        for(Map.Entry<String, Integer> entry: type.entrySet()){
            answer *= (entry.getValue() + 1);
        }
        
   
        return answer-1;
    }
}