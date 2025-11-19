import java.util.*;

class Solution {
    
    static int N, M;
    static int dx[] = {0, -1, 0, 1}, dy[] = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] mapInfo;
    
    public int[] solution(String[] maps) {
        
        N = maps.length;
        M = maps[0].length();

        mapInfo = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                char input = maps[i].charAt(j);
                if(input == 'X'){
                    mapInfo[i][j] = 0;
                }else{
                    mapInfo[i][j] = input - '0';
                }
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(mapInfo[i][j] > 0 && !visited[i][j]){
                    System.out.println(i+ " " + j);
                    int sum = findIsland(i,j);
                    pq.add(sum);
                }
            }
        }
        
        if(pq.size() == 0) {
            return new int[]{-1};
        }
        
        int[] answer = new int[pq.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = pq.poll();
        }
        
        return answer;
    }
    
    public int findIsland(int x, int y){
        
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {x, y});
        visited[x][y] = true;
        int sum = mapInfo[x][y];
        
        while(!que.isEmpty()){
            int now[] = que.poll();
            for(int i=0; i<4; i++){
                int nextX = now[0]+dx[i];
                int nextY = now[1]+dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(visited[nextX][nextY]) continue;
                if(mapInfo[nextX][nextY] == 0) continue;
                sum += mapInfo[nextX][nextY];
                visited[nextX][nextY] = true;
                que.add(new int[]{nextX, nextY});
            }
        }
        
        return sum;
        
    }

}