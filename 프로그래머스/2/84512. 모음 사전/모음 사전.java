import java.util.*;

class Solution {
    
    static TreeSet<String> make = new TreeSet<>();
    static String vowel[] = {"A", "E", "I", "O", "U"};
    static boolean visited[] = new boolean[5];
    
    public int solution(String word) {
        
        for(int i=1; i<=5; i++){
            permutation("", i);
        }
        
        return make.headSet(word).size() +1;
    }
    
    public void permutation(String word, int len){
        
        if(word.length() == len){
            make.add(word);
            return;
        }
        
        for(int i=0; i<vowel.length; i++){
            word = word + vowel[i];
            permutation(word, len);
            word = word.substring(0, word.length()-1);
        }
        
    }

}