import java.util.*;

class Solution {
    
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        
        int N = maps.length;
        int M = maps[0].length;
        
        boolean visited[][] = new boolean[N][M];
        visited[0][0] = true; 
        
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0,0,1});
        
        int answer = Integer.MAX_VALUE;
        
        while(!que.isEmpty()){
            int now[] = que.poll();
            int nowX = now[0];
            int nowY = now[1];
            int cnt = now[2];
            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(maps[nextX][nextY] == 0) continue;
                if(visited[nextX][nextY]) continue;
                // 배열안이면서 벽이아니고 방문한적이 없음 => 방문가능
                visited[nextX][nextY] = true;
                // 마지막인지 체크
                if(nextX == N-1 && nextY == M-1){
                    answer = Math.min(answer, cnt+1);
                    continue;
                }
                que.add(new int[]{nextX, nextY, cnt+1});
            }
        }
        
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        
        return answer;
    }
}