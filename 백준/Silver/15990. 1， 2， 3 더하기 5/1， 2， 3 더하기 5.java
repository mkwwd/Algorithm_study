import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int div = 1000000009;

        long dp[][] = new long[100001][4];

        dp[1][1]=1;
        dp[2][2]=1;
        dp[3][1]=1;
        dp[3][2]=1;
        dp[3][3]=1;

        for(int i=4; i<100001; i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3])%div;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3])%div;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2])%div;
        }

        for(int i=0; i<T; i++){
            int num = Integer.parseInt(br.readLine());
            long ans = ((dp[num][1]+dp[num][2])%div+dp[num][3])%div;
            sb.append(ans+"\n");
        }

        System.out.println(sb);

    }

}
