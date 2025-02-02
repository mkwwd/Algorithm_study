import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int iceberg[][], water[][], N, M;
    static int dx[] = {0, -1, 0, 1}, dy[] = {-1, 0, 1, 0};
    static boolean visited[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        iceberg = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int region;
        int cnt = 0;

        while(true){

            region = 0;
            visited  = new boolean[N][M];

            // 영역 계산
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(iceberg[i][j] <= 0) continue;
                    if(visited[i][j]) continue;
                    region++;
                    cntRegion(i, j);
                }
            }

            if(region != 1) break;

            cnt++;
            // 녹이기

            water = new int[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(iceberg[i][j] <= 0) continue;
                    melt(i, j);
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(water[i][j] <= 0) continue;
                    iceberg[i][j] -= water[i][j];
                }
            }

        }

        if(region == 0){
            System.out.println("0");
        }else{
            System.out.println(cnt);
        }

    }

    static void melt(int x, int y) {

        int cnt = 0;

        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
            if(iceberg[nextX][nextY] <= 0) cnt++;
        }

        water[x][y] = cnt;

    }

    static void cntRegion(int x, int y) {

        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {x, y});

        while(!que.isEmpty()){
            int now[] = que.poll();
            for(int i=0; i<4; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(iceberg[nextX][nextY] <= 0) continue;
                if(visited[nextX][nextY]) continue;
                visited[nextX][nextY] = true;
                que.add(new int[]{nextX, nextY});
            }
        }

    }

}
