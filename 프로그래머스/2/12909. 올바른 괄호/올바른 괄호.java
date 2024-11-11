import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> que = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            if(que.size() >= 1){
                if(now == ')' && que.peekLast() == '('){
                    que.pollLast();
                    continue;
                }
            }
            
            que.add(now);
        }
        
        if(!que.isEmpty()) answer = false;

        return answer;
    }
}