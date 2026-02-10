import java.util.*;

class Solution {
    public int solution(String s) {
        
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            Deque<Character> que = new ArrayDeque<>();
            for(int j=0; j<s.length(); j++){
                if(que.isEmpty()){
                    que.add(s.charAt(j));
                }else if(s.charAt(j) == '}' && que.peekLast() == '{'){
                    que.pollLast();
                }else if(s.charAt(j) == ']' && que.peekLast() == '['){
                    que.pollLast();
                }else if(s.charAt(j) == ')' && que.peekLast() == '('){
                    que.pollLast();
                }else{
                    que.add(s.charAt(j));
                }
            }
            if(que.isEmpty()) answer++;
            s = s.substring(1) + s.substring(0, 1);
        }
        
        return answer;
    }
}