import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] block = br.readLine().toCharArray();
        int dp[] = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(block[j] == 'B' && block[i] == 'O' && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
                }else if(block[j] == 'O' && block[i] == 'J' && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
                }else if(block[j] == 'J' && block[i] == 'B' && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
                }
            }
        }

        if(dp[N-1] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(dp[N-1]);
        }

    }

}
