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
            int N = Integer.parseInt(br.readLine());
            int coin[] = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                coin[j] = Integer.parseInt(st.nextToken());
            }

            int P = Integer.parseInt(br.readLine());
            int dp[][] = new int[N+1][P+1];
            for(int j=1; j<N+1; j++){
                for(int k=1; k<P+1; k++){
                    int gap = k-coin[j];
                    if(gap == 0){
                        dp[j][k] = dp[j-1][k] + 1;
                    }else if(gap > 0 && dp[j][gap] != 0){
                        dp[j][k] = dp[j-1][k] + dp[j][gap];
                    }else{
                        dp[j][k] = dp[j-1][k];
                    }
                }
            }

            sb.append(dp[N][P] + "\n");

        }

        System.out.println(sb);

    }
}
