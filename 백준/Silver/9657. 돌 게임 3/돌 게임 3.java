import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[1001];

        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;

        for(int i=5; i<N+1; i++){
            if(dp[i-1] == 1 && dp[i-3] == 1 && dp[i-4] == 1){
                dp[i] = 0;
            }else{
                dp[i] = 1;
            }
        }

        if(dp[N] == 1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
        
    }

}
