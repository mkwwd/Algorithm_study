import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        long arr[] = new long[N+1];

        arr[0] = 0;
        arr[1] = 0;
        if(N >= 2){
            arr[2] = 1;

            for(int i=3; i<N+1; i++){
                arr[i] = (i-1)*(arr[i-1] + arr[i-2])%1000000000;
            }
        }

        System.out.println(arr[N]);
    }

}


