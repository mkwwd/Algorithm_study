import java.util.*;

class Solution {
    public String solution(String s) {
        
        String word[] = s.split(" ");
        
        Arrays.sort(word, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return Integer.parseInt(s1) - Integer.parseInt(s2);
            }        
        });
        
        return word[0] + " " + word[word.length-1];
    }
}