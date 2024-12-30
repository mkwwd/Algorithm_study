import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        Deque<Integer> que = new ArrayDeque<>();
        int len = number.length() - k;
        for(int i=0; i<number.length(); i++){
            int num = number.charAt(i) - '0';
            while(k > 0 && !que.isEmpty()){
                if(que.peekLast() < num){
                    que.pollLast();
                    k--;
                }else break; 
            }
            que.add(num);
        }
        
        String answer = "";
        
        for(int i=0; i<len; i++){
            answer = answer + que.poll();
        }
        
        return answer;
    }
}