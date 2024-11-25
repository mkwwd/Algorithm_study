import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if(M == N) {
            System.out.println(1);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(0);
        pq.add(N+1);

        for(int i=0; i<M; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int dp[][] = new int[N+1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2; i<N+1; i++){
            dp[i][0] = dp[i-1][1];
            dp[i][1] = dp[i-1][0] + dp[i-1][1];
        }

        int sum = 1;

        while(pq.size() > 1){
            int from = pq.poll();
            int to = pq.poll();
            int gap = to - from-1;
            if(gap != 0){
                sum *= (dp[gap][0] + dp[gap][1]);
            }
            pq.add(to);
        }

        System.out.println(sum);

    }
}
