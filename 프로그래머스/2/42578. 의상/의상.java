import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> type = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            type.put(clothes[i][1], type.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;
        
        for(int value : type.values()){
            answer *= (value+1);
        }
   
        return answer-1;
    }
}