import java.util.*;

class Solution {
    
    static char miro[][];
    static int N, M;
    static int dx[] = {0, 1, 0, -1}, dy[]= {1, 0, -1, 0};
    
    public int solution(String[] maps) {
        
        int[][] point = new int[3][2];
        N = maps.length;
        M = maps[0].length();
        miro = new char[N][M];
        
        for(int i=0; i<N; i++){
            int len = M;
            for(int j=0; j<len; j++){
                miro[i][j] = maps[i].charAt(j);
                if(maps[i].charAt(j) == 'S'){
                    point[0][0] = i;
                    point[0][1] = j;
                }else if(maps[i].charAt(j) == 'L'){
                    point[1][0] = i;
                    point[1][1] = j;
                }else if(maps[i].charAt(j) == 'E'){
                    point[2][0] = i;
                    point[2][1] = j;
                }
            }    
        }
        
        int answer1 = 0;
        int answer2 = 0;
        answer1 = find(point[0], point[1]);
        answer2 = find(point[1], point[2]);    
        int answer = 0;
        
        if(answer1 != 0 && answer2 != 0){
            answer = answer1 + answer2;
        }else{
            answer = -1;
        }
        
        return answer;
    }
    
    static int find(int st[], int end[]){
        
        int cnt = 0;
        Deque<int[]> que = new ArrayDeque<>();
        boolean visited[][] = new boolean[N][M];
        que.add(new int[]{st[0], st[1], 0});
        visited[st[0]][st[1]] = true;
        
        while(!que.isEmpty()){
            int now[] = que.poll();
            if(now[0] == end[0] && now[1] == end[1]){
                cnt = now[2];	
                break;
            }
            for(int i=0; i<4; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(miro[nextX][nextY] == 'X') continue;
                if(visited[nextX][nextY]) continue;
                visited[nextX][nextY] = true;
                que.add(new int[] {nextX, nextY, now[2] + 1});
            }
        }
        
        return cnt;
        
    }
}