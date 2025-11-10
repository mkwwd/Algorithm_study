import java.util.*;

class Solution {
    
    static int N, M;
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {1, 0, -1, 0};
    static char gameBoard[][];
    static int min[][];
    
    public int solution(String[] board) {
        
        N = board.length;
        M = board[0].length();
        
        gameBoard = new char[N][M];
        min = new int[N][M];
        
        for(int i=0; i<N; i++){
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        
        int x = 0;
        int y = 0;
        
        for(int i=0; i<N; i++){
            String str = board[i];
            for(int j=0; j<M; j++){
                gameBoard[i][j] = str.charAt(j);
                if(gameBoard[i][j]=='R'){
                    x = i;
                    y = j;
                }
            }
        }
        
        int answer = moveRobot(x, y);
        
        return answer;
    }
    
    public int moveRobot(int x, int y){
        
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y, 0});
        
        while(!que.isEmpty()){
            int now[] = que.poll();
            if(gameBoard[now[0]][now[1]] == 'G'){
                return now[2];
            }
            for(int i=0; i<4; i++){
                int nextX = now[0];
                int nextY = now[1];
                while(nextX + dx[i] >= 0 && nextX + dx[i] <= N-1 && nextY + dy[i] >= 0 && nextY + dy[i] <= M-1){ 
                    nextX += dx[i];
                    nextY += dy[i];
                    if(gameBoard[nextX][nextY] == 'D'){
                        nextX -= dx[i];
                        nextY -= dy[i];
                        break;
                    }
                }
                if(now[0] == nextX && now[1] == nextY) continue;
                
                if(min[nextX][nextY] >= now[2]+1){
                    min[nextX][nextY] = now[2]+1;
                    que.add(new int[]{nextX, nextY, now[2]+1});
                }            
            }
        }
        
        return -1;
    }
    
}