import java.util.*;

class Solution {
    
    static int n,m;
    static int info[][];
    static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
    static boolean visited[][];
    
    public int[] solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        
        info = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char input = maps[i].charAt(j);
                if(input == 'X'){
                    info[i][j] = 0;
                }else{
                    info[i][j] = input - '0';
                }
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(info[i][j] == 0) continue;
                if(visited[i][j]) continue;
                visited[i][j] = true;
                int num = bfs(i, j);
                pq.add(num);
            }
        }
            
        int size = pq.size();
        
        if(size == 0) return new int[]{-1};
        
        int answer[] = new int[size];
        
        for(int i=0; i<size; i++){
            answer[i] = pq.poll();
        }
        
        return answer;
    }
    
    public int bfs(int x, int y){
        
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {x, y});
        int sum = info[x][y];
        
        while(!que.isEmpty()){
            int[] now = que.poll();
            for(int i=0; i<4; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                if(info[nextX][nextY] == 0) continue;
                if(visited[nextX][nextY]) continue;
                visited[nextX][nextY] = true;
                sum += info[nextX][nextY];
                que.add(new int[] {nextX, nextY});
            }
            
        }   
        
        return sum;
        
    }
    

}