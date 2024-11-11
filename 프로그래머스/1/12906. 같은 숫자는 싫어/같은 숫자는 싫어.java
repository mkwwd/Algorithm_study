import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> que = new ArrayDeque<>();
        
        for(int i=0; i<arr.length; i++){
            if(que.size() >= 1){
                if(que.peekLast() == arr[i]) continue;
            }
            que.add(arr[i]);
        }
        
        int[] answer = new int[que.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = que.poll();
        }

        return answer;
    }
}