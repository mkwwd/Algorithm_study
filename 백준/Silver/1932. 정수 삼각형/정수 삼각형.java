import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int tri[][] = new int[N+1][N+1];

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<i+1; j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=2; i<N+1; i++){
            for(int j=1; j<i+1; j++){
                tri[i][j] += Math.max(tri[i-1][j-1], tri[i-1][j]);
            }
        }

        int ans = 0;

        for(int i=0; i<N+1; i++){
            ans = Math.max(ans, tri[N][i]);
        }

        System.out.println(ans);
    }

}