import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        Deque<Integer> que = new ArrayDeque<>();
        int size = k;
        
        for(int i=0; i<number.length(); i++){
            int now = number.charAt(i) - '0';
            while(!que.isEmpty() && k > 0){
                if(que.peekLast() < now){
                    que.pollLast();
                    k--;
                }else break;
            }
            que.add(now);
        }
        
        String answer = "";
        for(int i=0; i<number.length() - size; i++){
            answer = answer + que.poll();
        }
        
        return answer;
    }
}