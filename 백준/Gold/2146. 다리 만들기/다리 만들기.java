import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, min = Integer.MAX_VALUE;
    static int map[][], dx[] = {0, -1, 0, 1}, dy[] = {-1, 0, 1, 0};
    static boolean visited[][];
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[N][N];
        int cnt = 0;
        
        // 같은 땅으로 갈수도 있기 때문에 땅 구분하기 
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]!=1) continue;
                if(visited[i][j]) continue;
                cnt++;
                map[i][j] = cnt;
                visited[i][j] = true;
                mark(i, j, cnt);
            }
        }
        
        // 다리놓기
        // 사용한 시작점 체크
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 땅 찾기
                if(map[i][j]==0) continue;
                // 주변에 바다가 있는지 확인하고 바다가 있으면 que에 넣고 bfs시작
                for(int k=0; k<4; k++) {
                    int seaX = i+dx[k];
                    int seaY = j+dy[k];
                    if(seaX<0 || seaX>=N || seaY<0 || seaY>=N) continue;
                    // 시작점으로 사용한 적이 있으면 하지 않음
                    if(visited[seaX][seaY]) continue;
                    if(map[seaX][seaY]==0) {
                        bridge(seaX, seaY, map[i][j]);
                        visited[seaX][seaY] = true;
                    }
                }
            }
        }
        
        System.out.println(min);
        
    }
    


    private static void bridge(int seaX, int seaY, int land) {
        
        Deque<int[]> sea = new ArrayDeque<>();
        // 방문체크
        boolean isVisited[][] = new boolean[N][N];
        isVisited[seaX][seaY] = true;
        int cnt = 1;
        
        sea.add(new int[] {seaX, seaY, cnt});        
        
        while(!sea.isEmpty()) {
            
            int now[] = sea.poll();
            
            for(int i=0; i<4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX<0 || nextX>=N || nextY<0 || nextY>=N) continue;
                // 방문학적 있으면 continue
                if(isVisited[nextX][nextY]) continue;
                // 자기 자신이면 continue
                if(map[nextX][nextY]==land) continue;
                // 최솟값보다 크면 더 할 이유가 없음
                if(now[2] >= min) continue;                
                // 0이면 큐에 추가
                // 다른 땅에 도착하면 최솟값 체크
                if(map[nextX][nextY]==0) {
                	isVisited[nextX][nextY] = true;
                    sea.add(new int[] {nextX, nextY, now[2]+1});
                }else{
                    min = Math.min(min, now[2]);
                }
            }
            
        }
        
    }


    private static void mark(int x, int y, int cnt) {
        
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {x , y});
        
        while(!que.isEmpty()) {
            int now[] = que.poll();
            for(int i=0; i<4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX<0 || nextX>=N || nextY<0 || nextY>=N) continue;
                if(visited[nextX][nextY]) continue;
                if(map[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = cnt;
                    que.add(new int[] {nextX, nextY});
                }
            }
        }
        
    }

}
