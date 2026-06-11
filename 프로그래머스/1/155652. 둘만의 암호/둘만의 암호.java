import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        
        ArrayList<Character> alphabet = new ArrayList<>();
        
        for(int i=97; i<=122; i++){
            alphabet.add((char)i);
        }
        
        for(int i=0; i<skip.length(); i++){
            int idx = alphabet.indexOf(skip.charAt(i));
            alphabet.remove(idx);
        }
        
        String answer = "";
        
        int size = alphabet.size();
        
        for(int i=0; i<s.length(); i++){
            int idx = alphabet.indexOf(s.charAt(i));
            idx = (idx+index)%size;
            answer += alphabet.get(idx);
        }
        
        return answer;
    }
}