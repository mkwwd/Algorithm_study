import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N, K, time, cnt;
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        time = 10000;

        // 수빈
        N = Integer.parseInt(st.nextToken());
        // 동생
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        if(N >= K) {
            time = N - K;
        }else {
            bfs();
        }

        System.out.println(time);

    }

    private static void bfs() {

        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {N*2, 0});
        que.add(new int[] {N-1, 1});
        que.add(new int[] {N+1, 1});


        while(!que.isEmpty()) {

            int[] now = que.poll();

            if(now[0] < 0 || now[0] > 100000)  continue;

            if(now[0] == K) {
                time = now[1];
                return;
            }
            visited[now[0]] = true;

            if(now[0]*2 <= 100000 && !visited[now[0]*2]) {
                que.addFirst(new int[] {now[0]*2, now[1]});
            }
            if(0<= now[0]-1 && !visited[now[0]-1]) {
                que.add(new int[] {now[0]-1, now[1]+1});
            }
            if(now[0]+1 <= 100000 && !visited[now[0]+1]) {
                que.add(new int[] {now[0]+1, now[1]+1});
            }


        }

    }

}
