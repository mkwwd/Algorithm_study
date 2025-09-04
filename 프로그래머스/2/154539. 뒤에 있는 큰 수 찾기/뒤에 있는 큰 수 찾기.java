import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Deque<Integer> que = new ArrayDeque<>();
        int answer[] = new int[numbers.length];
        
        for(int i=numbers.length-1; i>=0; i--){
            while(!que.isEmpty()){
                if(que.peekLast() <= numbers[i]) que.pollLast();
                else break;
            }
            if(que.isEmpty()){
                answer[i] = -1;
            }else answer[i] = que.peekLast();
            que.add(numbers[i]);
        }

        return answer;
    }
}