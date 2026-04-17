import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        Deque<Integer> que = new ArrayDeque<>();
        int size = k;
        
        for(int i=0; i<number.length(); i++){
            int now = number.charAt(i) - '0';
            while(!que.isEmpty() && size > 0){
                if(que.peekLast() < now){
                    que.pollLast();
                    size--;
                }else break;
            }
            que.add(now);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<number.length()-k ; i++){
            sb.append(que.poll());
        }
        
        return sb.toString();
    }
}