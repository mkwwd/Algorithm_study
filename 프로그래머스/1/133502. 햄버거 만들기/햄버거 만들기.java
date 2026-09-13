import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        
        
        Deque<Integer> que = new ArrayDeque<>();
        int answer = 0;
        
        for(int i=0; i<ingredient.length; i++){
            if(ingredient[i] == 1){
                if(!que.isEmpty() && que.peekLast() == 3){
                    que.pollLast();
                }else{
                    que.add(1);
                    continue;
                }
                if(!que.isEmpty() && que.peekLast() == 2){
                    que.pollLast();
                }else{
                    que.add(3);
                    que.add(1);
                    continue;
                }
                if(!que.isEmpty() && que.peekLast() == 1){
                    que.pollLast();
                    answer++;
                }else{
                    que.add(2);
                    que.add(3);
                    que.add(1);
                    continue;
                }
            }else{
                que.add(ingredient[i]);
            }
        }

        return answer;
    }
}