import java.util.*;

class Solution {
    
    static int N, M;
    static int dx[] = {0, -1, 0, 1}, dy[] = {-1, 0, 1, 0};
    static int[][] oilArea;
    static boolean[][] visited;
    
    public int solution(int[][] land) {
        
        N = land.length;
        M = land[0].length; 
        
        ArrayList<Integer> oil = new ArrayList<>();
        oil.add(0, 0);
        oilArea = new int[N][M];
        visited = new boolean[N][M];
        int num = 1;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    oilArea[i][j] = num;
                    int total = calculateOil(land, i, j, num);
                    oil.add(num, total);
                    num++;
                }
            }
        }
        
        boolean check[];
        
        int max = 0;
        for(int i=0; i<M; i++){
            check = new boolean[num];
            int sum = 0;
            for(int j=0; j<N; j++){
                if(oilArea[j][i] == 0) continue;
                if(check[oilArea[j][i]]) continue;
                sum += oil.get(oilArea[j][i]);
                check[oilArea[j][i]] = true;
            }
            max = Math.max(max, sum);
        }
            
        
        return max;
    }
    
    public static int calculateOil(int[][] land, int x, int y, int num){
        
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        int cnt = 1;
        
        while(!que.isEmpty()){
            
            int[] now = que.poll();
            for(int i=0; i<4; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(land[nextX][nextY] == 0) continue;
                if(visited[nextX][nextY]) continue;
                visited[nextX][nextY] = true;
                oilArea[nextX][nextY] = num;
                cnt++;
                que.add(new int[]{nextX, nextY});
            }
            
        }
        
        return cnt;
        
    }
    
}