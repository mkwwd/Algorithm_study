import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int chu[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            chu[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(chu);

        int min = 0;
        for (int i=0; i<N; i++){
            if(min +1 < chu[i]) break;
            min += chu[i];
        }

        System.out.print(min + 1);

    }

}
