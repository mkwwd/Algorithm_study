import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int div = 1000000009;

        int dp[][] = new int[100001][2];

        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][1] = 2;

        for(int i=4; i<100001; i++){
            dp[i][0] = ((dp[i-1][1] + dp[i-2][1])%div + dp[i-3][1])%div;
            dp[i][1] = ((dp[i-1][0] + dp[i-2][0])%div + dp[i-3][0])%div;
        }

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            sb.append(dp[n][1]+" "+dp[n][0]+"\n");

        }

        System.out.println(sb);

    }

}
