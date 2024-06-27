import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int bus[][] = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
           st = new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());
           int value = Integer.parseInt(st.nextToken());
           if(bus[start][end] == 0 || bus[start][end] > value){
               bus[start][end] = value;
           }
        }

        for (int k = 0; k < N+1; k++) {
            for (int i = 0; i < N+1; i++) {
                for (int j = 0; j < N+1; j++) {
                    if(i == j) continue;
                    if (bus[i][k] != 0 && bus[k][j] != 0) {
                        if(bus[i][j] == 0) {
                            bus[i][j] = bus[i][k] + bus[k][j];
                        }else{
                            bus[i][j] = Math.min(bus[i][j], bus[i][k] + bus[k][j]);
                        }
                    }
                }
            }
        }

        for(int i= 1; i<+N+1; i++){
            for(int j=1; j<N+1; j++){
                sb.append(bus[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        

    }

}
