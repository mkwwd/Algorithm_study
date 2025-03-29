import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    
    public int solution(int[][] board) {
        
        int N = board.length;
        int dp[][][] = new int[N][N][4];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue <int[]> que = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[3] - o2[3];
            }
        });
        
        for (int i = 0; i < 4; i++) {
            dp[0][0][i] = 0;
        }
        
        que.add(new int[] {0, 0, -1, 0});
        
        while(!que.isEmpty()){
            int now[] = que.poll();
            int nowX = now[0];
            int nowY = now[1];
            int dir = now[2];
            int save = now[3];
            
            if(dir != -1 && dp[nowX][nowY][dir] < save) continue;
            
            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if (board[nextX][nextY] == 1) continue;
                int cost = save + 100;
                if (dir != i && dir != -1) cost += 500;
                if(dp[nextX][nextY][i] >= cost){
                    dp[nextX][nextY][i] = cost;
                    que.add(new int[] {nextX, nextY, i, cost});
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<4; i++){
            min = Math.min(min, dp[N-1][N-1][i]);
        }

        return min;
    }
}