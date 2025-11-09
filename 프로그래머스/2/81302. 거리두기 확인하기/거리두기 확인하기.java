import java.util.*;

class Solution {
    
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, -1, 0, 1};
    
    public int[] solution(String[][] places) {
        
        int N = places.length;
        int answer[] = new int[N];
        
        for(int i=0; i<N; i++){
            String[][] wRoom = new String[5][5];
            for(int j=0; j<5; j++){
                wRoom[j] = places[i][j].split("");
            }
            
            boolean isPoss = checkDis(wRoom);
            
            if(isPoss) answer[i] = 1;
            
        }
      
        return answer;
    }
    
    public boolean checkDis(String[][] wRoom){
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(wRoom[i][j].equals("P")){
                    
                    Deque<int[]> que = new ArrayDeque<>();
                    que.add(new int[]{i, j, 0});
                    boolean visited[][] = new boolean[5][5];
                    visited[i][j] = true;
                    
                    while(!que.isEmpty()){
                        int[] now = que.poll();
                        if(now[2] >= 2) continue;
                        for(int k=0; k<4; k++){
                            int nextX = now[0] + dx[k];
                            int nextY = now[1] + dy[k];
                            if(nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) continue;
                            if(wRoom[nextX][nextY].equals("X")) continue;
                            if(visited[nextX][nextY]) continue;
                            visited[nextX][nextY] = true;
                            if(wRoom[nextX][nextY].equals("P") && now[2] + 1 <= 2) {
                                return false;
                            }
                            que.add(new int[]{nextX, nextY, now[2]+1});
                        }
                    }
                }
            }
        }
        
        return true;
        
    }
    
}