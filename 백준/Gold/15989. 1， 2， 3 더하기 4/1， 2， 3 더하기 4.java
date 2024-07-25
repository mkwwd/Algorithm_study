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

        for(int i=0; i<T; i++){
            int coin[] = new int[] {1 ,2, 3};

            int P = Integer.parseInt(br.readLine());
            int dp[] = new int[P+1];
            dp[0] = 1;
            for(int j=0; j<3; j++){
                for(int k=coin[j]; k<P+1; k++){
                    dp[k] += dp[k - coin[j]];
                }
            }

            sb.append(dp[P] + "\n");

        }

        System.out.println(sb);

    }
}
