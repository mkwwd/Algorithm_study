import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int sub[][] = new int[N+1][2];

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            sub[i][0] = k;
            sub[i][1] = s;
        }

        int bag[][] = new int[N+1][T+1];

        for(int i=1; i<N+1; i++){
            for(int j=1; j<T+1; j++){
                if(j-sub[i][0] >= 0){
                    bag[i][j] = Math.max(bag[i-1][j], sub[i][1] + bag[i-1][j-sub[i][0]]);
                }else{
                    bag[i][j] = bag[i-1][j];
                }
            }
        }

        System.out.println(bag[N][T]);

    }
}
