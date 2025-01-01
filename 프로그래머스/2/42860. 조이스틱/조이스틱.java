import java.util.*;

class Solution {
    public int solution(String name) {
        
        int answer = 0;
        int len = name.length();
        int min = len - 1;
        
        for(int i=0; i<len; i++){
            char now = name.charAt(i);
            int gap = Math.min(now-'A', 'Z'-now+1);
            answer += gap;
            
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A'){
                next ++;
            }
            
            // 앞으로 가서 뒤로 A가 끝나는 지점
            min = Math.min(min, i*2 + len-next);
            // 처음에 뒤에 처리하고 다시 앞으로 와서 처리
            min = Math.min(min, (len-next)*2 + i);
        }        
        
        answer += min;
        return answer;
    }
}