import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long [] pado = new long[100];

        for(int i=0; i<100; i++){
            if(i<3){
                pado[i] = 1;
                continue;
            }
            pado[i] = pado[i-3] + pado[i-2];
        }

        for(int i=0; i<T; i++){
            int a = Integer.parseInt(br.readLine());
            sb.append(pado[a-1]).append("\n");
        }

        System.out.print(sb);

    }
}
