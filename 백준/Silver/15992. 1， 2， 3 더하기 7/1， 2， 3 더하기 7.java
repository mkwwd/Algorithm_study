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

        int dp[][] = new int[1001][1001];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;

        for(int i=4; i<1001; i++){
            for(int j=2; j<=i; j++){
                dp[i][j] = ((dp[i-1][j-1] + dp[i-2][j-1])%div + dp[i-3][j-1])%div;
            }
        }

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(dp[n][m]+"\n");

        }

        System.out.println(sb);

    }

}
