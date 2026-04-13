import java.util.*;

class Solution {
    boolean solution(String s) {
        
        boolean answer = true;
        
        Deque<Character> que = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')' && !que.isEmpty() && que.peekLast() == '('){
                que.pollLast();
                continue;
            }
            que.add(s.charAt(i));
        }
        
        if(!que.isEmpty()) answer = false;

        return answer;
    }
}