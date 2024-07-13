import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int dp[] = new int[1000001];
        int div = 1000000009;

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<1000001; i++){
            dp[i] = ((dp[i-1] + dp[i-2])%div + dp[i-3])%div;
        }

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N] + "\n");
        }

        System.out.println(sb);

    }
}
