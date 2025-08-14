import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayDeque<int[]> work = new ArrayDeque<>();
        ArrayDeque<Integer> finish = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++){
            work.add(new int[] {progresses[i], speeds[i]});
        }
        
        int index = 1;
        
        while(!work.isEmpty()){
            int cnt = 0;
            int size = work.size();
            for(int i=0; i<size; i++){
                int now[] = work.peek();
                if(now[0]+now[1]*index >= 100){
                    cnt++;
                    work.poll();
                }else break;
            }
            if(cnt > 0){
                finish.add(cnt);
            }
            index++;
        }
        
        int len = finish.size();
        int answer[] = new int[len];
        
        for(int i=0; i<len; i++){
            answer[i] = finish.poll();
        }
        
        return answer;
    }
}