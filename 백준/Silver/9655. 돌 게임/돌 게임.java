import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for(int i=4; i<N+1; i++){
            if(dp[i-1] == 1 && dp[i-3]==1){
                dp[i] = 2;
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
