import java.util.*;

class Solution {
    
    static int min = 0;
    static boolean isUsed[];
    
    public int solution(String begin, String target, String[] words) {
        
        int n = words.length;
        min = n;
        isUsed = new boolean[n+1];
        
        dfs(begin, target, words, 0);
        
        if(min == words.length) min = 0;
        
        return min;
    }
    
    public void dfs(String begin, String target, String[] words, int change){
        
        if(change >= min) return;
        
        if(begin.equals(target)){
            min = Math.min(change, min);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            String now = words[i];
            if(isUsed[i]) continue;
            int cnt = 0;
            for(int j=0; j<now.length(); j++){
                if(begin.charAt(j) != now.charAt(j)) cnt++;
            }
            
            if(cnt == 1){
                isUsed[i] = true;
                dfs(now, target, words, change+1);
                isUsed[i] = false;
            }
        }
        
    }
       
}