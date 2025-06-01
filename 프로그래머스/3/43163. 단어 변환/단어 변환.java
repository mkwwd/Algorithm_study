import java.util.*;

class Solution {
    
    static int min = 0;
    
    public int solution(String begin, String target, String[] words) {
        
        int answer = 0;
        min = words.length;
        
        boolean use[] = new boolean[words.length];
        
        dfs(begin, target, words, use, 0);
        
        if(min == words.length){
            min = 0;
        } 
        
        return min;
    }
    
    public void dfs(String begin, String target, String[] words, boolean[] use, int sum){
        
        System.out.println(begin + target + sum);
        
        if(sum > words.length || sum > min) return;
        
        if(begin.equals(target)){
            min = Math.min(min, sum);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(use[i]) continue;
            int cnt = 0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) != words[i].charAt(j)) cnt++;
            }
           
            if(cnt == 1){
                use[i] = true;
                dfs(words[i], target, words, use, sum+1);
                use[i] = false;
            }
            
        }
        
    }
    
}