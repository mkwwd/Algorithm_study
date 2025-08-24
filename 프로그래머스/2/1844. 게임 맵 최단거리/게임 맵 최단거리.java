import java.util.*;

class Solution {
    
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        
        int N = maps.length;
        int M = maps[0].length;
        boolean visited[][] = new boolean[N][M];
        visited[0][0] = true;
        
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0, 1});
        
        int answer = Integer.MAX_VALUE;
        
        while(!que.isEmpty()){
            int now[] = que.poll();
            for(int i=0; i<4; i++){
                int nextX = now[0]+dx[i];
                int nextY = now[1]+dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(maps[nextX][nextY] == 0) continue;
                if(visited[nextX][nextY]) continue;
                visited[nextX][nextY] = true;
                if(nextX == N-1 && nextY == M-1){
                    answer = now[2]+1;
                    break;
                }
                que.add(new int[]{nextX, nextY, now[2]+1});
            }
        }
        
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }

        return answer;
    }
}