import java.util.*;

class Solution {
    
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, -1, 0, 1};
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++){
            String[][] room = new String[5][5];
            for(int j=0; j<5; j++){
                room[j] = places[i][j].split("");
            }
            
            int result = 1;
            
            for(int j=0; j<5; j++){
                boolean isposs = true;
                for(int k=0; k<5; k++){
                    if(room[j][k].equals("P")){
                        isposs = checkDis(room, j, k);
                    }
                    
                    if(!isposs) break;
                }
                
                if(!isposs) {
                    result = 0;
                    break;
                }
            }
            
            answer[i] = result;
        }
      
        return answer;
    }
    
    public boolean checkDis(String[][] room, int x, int y){
        
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {x, y, 0});
        boolean visited[][] = new boolean[5][5];
        visited[x][y] = true;
        
        while(!que.isEmpty()){
            int now[] = que.poll();
            for(int i=0; i<4; i++){
                if(now[2] >= 2) continue;
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) continue;
                if(visited[nextX][nextY]) continue;
                if(room[nextX][nextY].equals("P")) return false;
                visited[nextX][nextY] = true;
                if(room[nextX][nextY].equals("O")){
                    que.add(new int[]{nextX, nextY, now[2]+1});
                }
            }
        }
        
        return true;
    }
}