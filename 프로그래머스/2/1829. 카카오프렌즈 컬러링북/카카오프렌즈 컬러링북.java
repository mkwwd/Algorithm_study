import java.util.*;

class Solution {
    
    static boolean visited[][];
    static int M, N;
    static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
    
    public int[] solution(int m, int n, int[][] picture) {
        
        int area = 0;
        int max = 0;
        M = m;
        N = n;
        
        visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] == 0) continue;
                if(visited[i][j]) continue;
                area++;
                max = Math.max(max, sumArea(i, j, picture));
            }
        }
        
        int answer[] = {area, max};
        
        return answer;
    }
    
    public int sumArea(int x, int y, int[][] picture){
        
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        int area = 1;
        visited[x][y] = true;
        
        while(!que.isEmpty()){
            int now[] = que.poll();
            visited[now[0]][now[1]] = true;
            for(int i=0; i<4; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
                if(visited[nextX][nextY]) continue;
                if(picture[now[0]][now[1]] == picture[nextX][nextY]){
                    area++;
                    visited[nextX][nextY] = true;
                    que.add(new int[]{nextX, nextY});
                }
            }
        }
        
        return area;
    }
}