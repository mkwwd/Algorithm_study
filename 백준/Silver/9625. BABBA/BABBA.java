import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int A[] = new int[46];
        int B[] = new int[46];

        A[0] = 1;
        B[0] = 0;

        for(int i=1; i<N+1; i++){
            A[i] = B[i-1];
            B[i] = A[i-1] + B[i-1];
        }

        System.out.println(A[N]+" "+B[N]);

    }

}
