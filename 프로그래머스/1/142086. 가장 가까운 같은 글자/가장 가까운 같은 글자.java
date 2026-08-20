import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int answer [] = new int[s.length()];
        
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            int index = map.getOrDefault(a, -1);
            map.put(a, i);
            if(index == -1){
                answer[i] = index;
            }else{
                answer[i] = i-index;
            }         
        }

        return answer;
    }
}