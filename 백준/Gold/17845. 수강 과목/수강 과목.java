import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int sub[][] = new int[K+1][2];

        for(int i=1; i<=K; i++){
            st = new StringTokenizer(br.readLine());
            sub[i][0] = Integer.parseInt(st.nextToken());
            sub[i][1] = Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[K+1][N+1];

        for(int i=1; i<=K; i++){
            for(int j=1; j<=N; j++){
                int gap = j - sub[i][1];
                if(gap >= 0){
                    dp[i][j] = Math.max(dp[i-1][j], sub[i][0] + dp[i-1][gap]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }


        System.out.println(dp[K][N]);

    }

}
