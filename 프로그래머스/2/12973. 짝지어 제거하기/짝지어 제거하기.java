import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> que = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            if(!que.isEmpty() && que.peekLast() == s.charAt(i)){
                que.pollLast();
            }else{
                que.add(s.charAt(i));
            }
        }        
        
        if(que.isEmpty()){
            return 1;
        }else{
            return 0;
        }

    }
}