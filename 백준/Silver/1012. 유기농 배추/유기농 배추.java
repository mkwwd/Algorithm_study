import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int field[][];
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    static  Deque<int[]> cabbage;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            field = new int [N][M];
            cabbage = new ArrayDeque<>();

            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            int ans = 0;

            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(field[j][k] == 0) continue;
                    // 배추이면 집어넣음
                    cabbage.add(new int[] {j,k});
                    ans ++;
                    while(!cabbage.isEmpty()){
                        int now[] = cabbage.poll();
                        int nowX = now[0];
                        int nowY = now[1];
                        // 현재 0으로 만들기
                        field[nowX][nowY] = 0;
                        checkCabbage(nowX, nowY);
                    }
                }
            }

            System.out.println(ans);
        }

    }

    public static void checkCabbage(int x, int y){
        for(int i=0; i<4; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            if(newX < 0 || newX >=N || newY <0 || newY >=M) continue;
            // 범위안이라면 배추인지 확인
            if(field[newX][newY] == 1){
                field[newX][newY] = 0;
                cabbage.add(new int[]{newX, newY});
            }
        }
    }
}
