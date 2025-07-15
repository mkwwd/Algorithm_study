import java.util.*;

class Solution {
     
    public int solution(int x, int y, int n) {
        
        int answer = -1;
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{y, 0});
        
        while(!que.isEmpty()){
            int now[] = que.poll();
            int nowY = now[0];
            if(nowY < x) continue;
            if(nowY == x){
                answer = now[1];
                break;
            }
            if(nowY%3 == 0){
                que.add(new int[]{nowY/3, now[1]+1});
            }
            if(nowY%2 == 0){
                que.add(new int[]{nowY/2, now[1]+1});
            }
            que.add(new int[]{nowY-n, now[1]+1});
        }
       
        return answer;
    }
    
}