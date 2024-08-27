import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int bus[][] = new int[N+1][N+1];

        for(int i=0; i<N+1; i++){
            for(int j=0; j<N+1; j++){
                if(i==j){
                    bus[i][j] = 0;
                    continue;
                }
                bus[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            bus[start][end] = Math.min(bus[start][end], value);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int fee[] = new int[N+1];
        for(int i=1; i<N+1; i++){
            fee[i] = Integer.MAX_VALUE;
        }

        Deque<Integer> que = new ArrayDeque<>();
        que.add(start);
        fee[start] = 0;

        while(!que.isEmpty()){
            int now = que.poll();
            for(int i=1; i<N+1; i++){
                // 버스 노선이 있는지 확인히가
                if(bus[now][i] == Integer.MAX_VALUE) continue;
                // 지금 경로 비용 fee[now] + bus[now][i]
                // 저장되어 있는 경로 fee[i] 비교하기
                // 지금 경로 비용이 더 작으면 바꿔주기
                if(fee[now]+bus[now][i] >= fee[i]) continue;
                fee[i] = fee[now]+bus[now][i];
                que.add(i);
            }
        }

        System.out.println(fee[end]);

    }

}
