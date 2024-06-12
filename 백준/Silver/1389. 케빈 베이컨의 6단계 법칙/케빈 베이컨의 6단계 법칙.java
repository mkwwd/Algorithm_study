import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int ans = 0;

        int info[][] = new int [N+1][N+1];

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            info[a][b] = 1;
            info[b][a] = 1;
        }

        for(int i=1; i<=N; i++){
            Deque<int[]> arr = new ArrayDeque<>();
            for(int j=1; j<=N; j++){
                // 현재 지금 아는 사이인 사람 que에 넣기
                if(info[i][j] == 1){
                    arr.add(new int[]{j, 1});
                }
            }

            boolean visited[] = new boolean[N+1];
            visited[i] = true;

            while (!arr.isEmpty()){
                int now[] = arr.poll();
                int next = now[0];
                for(int j=1; j<=N; j++){
                    // 1이면 집어넣기
                    if(info[next][j] == 1 && !visited[j]){
                        // 1인데 이미 방문했으면 패스
                        visited[j] = true;
                        arr.add(new int[]{j, now[1]+1});
                        if(info[i][j] != 0) continue;
                        info[i][j] = now[1]+1;
                        info[j][i] = now[1]+1;

                    }
                }
            }

            // 다 끝난 후에 케빈베이컨수 체크
            int sum = 0;
            for(int j=1; j<=N; j++){
                sum += info[i][j];
            }

            if(sum < min){
                min = sum;
                ans = i;
            }

        }

        System.out.println(ans);
    }
}
