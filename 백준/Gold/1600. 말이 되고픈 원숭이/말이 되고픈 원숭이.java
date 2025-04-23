import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int K, H, W;
    static int board[][];
    static boolean visited[][][];

    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    static int hx[] = {-1, -2, -2, -1, 1, 2, 2, 1}, hy[] = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        board = new int[W][H];
        visited = new boolean[K+1][W][H];

        for(int i=0; i<W; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<H; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = bfs();

        System.out.println(answer);

    }

    public static int bfs(){

        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {0, 0, 0, 0});
        visited[0][0][0] = true;

        while(!que.isEmpty()){

            int now[] = que.poll();
            if(now[0] == W-1 && now[1] == H-1) return now[3];

            for(int i=0; i<4; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX < 0 || nextX >= W || nextY < 0 || nextY >= H) continue;
                if(board[nextX][nextY] == 1) continue;
                if(visited[now[2]][nextX][nextY]) continue;
                visited[now[2]][nextX][nextY] = true;
                que.add(new int[] {nextX, nextY, now[2], now[3] + 1});
            }

            if(now[2] < K){
                for(int i=0; i<8; i++){
                    int nextX = now[0] + hx[i];
                    int nextY = now[1] + hy[i];
                    if(nextX < 0 || nextX >= W || nextY < 0 || nextY >= H) continue;
                    if(board[nextX][nextY] == 1) continue;
                    if(visited[now[2] + 1][nextX][nextY]) continue;
                    visited[now[2] + 1][nextX][nextY] = true;
                    que.add(new int[] {nextX, nextY, now[2] +1, now[3] +1});
                }
            }

        }

        return -1;
    }

}
