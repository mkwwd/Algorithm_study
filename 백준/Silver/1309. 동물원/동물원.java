import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int lion[][] = new int[N][3];
        int MOD = 9901;

        lion[0][0] = lion[0][1] = lion[0][2] = 1;

        for(int i=1; i<N; i++){
            lion[i][0] = ((lion[i-1][0] + lion[i-1][1])%MOD + lion[i-1][2])%MOD;
            lion[i][1] = (lion[i-1][0] + lion[i-1][2])%MOD;
            lion[i][2] = (lion[i-1][0] + lion[i-1][1])%MOD;
        }

        System.out.println((lion[N-1][0] + lion[N-1][1] +lion[N-1][2])%MOD);

    }

}
