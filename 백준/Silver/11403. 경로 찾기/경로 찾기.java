import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int dot[][] = new int[N][N];

        for(int i= 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                dot[i][j] = num;
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dot[i][k] == 1 && dot[k][j] == 1) {
                        dot[i][j] = 1;
                    }
                }
            }
        }

        for(int i= 0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(dot[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
