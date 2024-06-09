import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    static int N, M;
    static int box[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new int[M][N];
        Deque<int[]> ripe = new ArrayDeque<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int egg = Integer.parseInt(st.nextToken());
                box[i][j] = egg;
                if(egg == 1) ripe.add(new int[]{i,j});
            }
        }

        int day = 0;
        int size = ripe.size();
        while(size >= 0){
            int cnt = 0;
            while(cnt < size){
                int ripTo[] = ripe.poll();
                int m = ripTo[0];
                int n = ripTo[1];
                //익토 근처에 안익토 있는지 확인
                for(int i=0; i<4; i++){
                    int newM = m + dx[i];
                    int newN = n + dy[i];
                    // 범위확인
                    if(newM<0 || newM>=M || newN<0 || newN>=N) continue;
                    // 범위이면 멀쩡토마토 찾기
                    if(box[newM][newN] != 0) continue;
                    // 멀쩡토마토 찾았으면 익히고 다음으로
                    box[newM][newN] = 1;
                    ripe.add(new int[]{newM, newN});
                }
                cnt ++;
            }

            size = ripe.size();
            // 익은 토마토가 없으면 스탑
            if(size == 0){
                //남은 안익토가 있는지 확인
                int toma = check();
                // 남은게 있으면 day = -1
                if(toma != 0) day = -1;
                break;
            }else{
                day++;
            }

        }

        System.out.println(day);
    }

    private static int check(){
        int toma = 0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(box[i][j] == 0) toma++;
            }
        }
        return toma;
    }
}
