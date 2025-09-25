import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
       
        int cnt = 0;
        String before = "";
        
        HashSet<String> used = new HashSet<>();
        
        for(int i=0; i<words.length; i++){
            if(used.contains(words[i])) break;
            if(before.length() == 0 || before.charAt(before.length()-1) == words[i].charAt(0)){
                before = words[i];
                used.add(words[i]);
                cnt++;
            }else break;
        }
        
        if(cnt == words.length) return new int[] {0,0};
        
        cnt++;
        
        int num = cnt%n;
        if(num == 0) num = n;
        
        int turn = (int)Math.ceil((double)cnt/n);
       
        return new int[] {num, turn};
    }
}