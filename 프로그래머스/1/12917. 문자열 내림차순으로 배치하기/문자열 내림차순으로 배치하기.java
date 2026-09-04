import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] word = s.split("");
        
        Arrays.sort(word);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<word.length; i++){
            sb.append(word[i]);
        }
        
        return sb.reverse().toString();
    }
}