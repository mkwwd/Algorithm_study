import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int div = 1000000009;

        int dp[] = new int[100001];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;

        for(int i=6; i<100001; i++){
            dp[i] = ((dp[i-2] + dp[i-4])%div + dp[i-6])%div;
        }

        for(int i=0; i<T; i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num] + "\n");
        }

        System.out.println(sb);

    }


}
