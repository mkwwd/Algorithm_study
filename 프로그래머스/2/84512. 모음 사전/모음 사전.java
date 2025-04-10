import java.util.*;

class Solution {
    
    static TreeSet<String> words = new TreeSet<>();
    static boolean[] use = new boolean[5];
    static String vowel = "AEIOU";
    
    public int solution(String word) {
        
        for(int i=1; i<=5; i++){
            permutation("", 0, i);
        }
        
        return words.headSet(word).size() + 1;
    }
    
    public void permutation(String sum, int cnt, int len){
        
        if(sum.length() == len){
            words.add(sum);
            return;
        }
        
        for(int i=0; i<5; i++){
            sum  = sum + vowel.charAt(i);
            permutation(sum, cnt+1, len);
            sum = sum.substring(0, sum.length()-1);
        }
        
    }

}