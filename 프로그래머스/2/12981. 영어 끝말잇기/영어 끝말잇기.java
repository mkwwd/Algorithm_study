import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
       
        String now = words[0];
        int cnt = 1;
        HashSet<String> said = new HashSet<>();
        said.add(now);
        
        for(int i=1; i<words.length; i++){
            if(now.charAt(now.length() -1) != words[i].charAt(0)) break;
            if(said.contains(words[i])) break;
            cnt ++;
            said.add(words[i]);
            now = words[i];
        }
        
        int[] answer;
        
        if(cnt == words.length){
            answer = new int[] {0, 0};
        }else{
            cnt++;
            if(cnt%n == 0){
                answer = new int[] {n, cnt/n};
            }else{
                answer = new int[] {cnt%n, (int)Math.ceil((double)cnt/n)};
            }
        }

        return answer;
    }
}