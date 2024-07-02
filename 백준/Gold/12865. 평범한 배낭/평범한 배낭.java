import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int item[][] = new int[N+1][2];

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            item[i][0] = w;
            item[i][1] = v;
        }

        int bag[][] = new int[N+1][K+1];

        for(int i=1; i<N+1; i++){
            for(int j=1; j<K+1; j++){
                if(j-item[i][0] >= 0){
                    bag[i][j] = Math.max(bag[i-1][j], item[i][1] + bag[i-1][j-item[i][0]]);
                }else{
                    bag[i][j] = bag[i-1][j];
                }
            }
        }

        System.out.println(bag[N][K]);

    }
}
