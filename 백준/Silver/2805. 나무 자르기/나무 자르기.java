import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int tree[] = new int[N];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        long min = 0;
        for(int i=0; i<N; i++){
            int height = Integer.parseInt(st.nextToken());
            tree[i] = height;
            max = Math.max(max, height);
            min = Math.min(min, height);
        }

        long ans = 0;

        while(min <= max){
            long sum = 0;
            long height = (max + min)/2;
            for(int i=0; i<N; i++){
                long gap = tree[i] - height;
                if(gap > 0) sum += gap;
            }

            if(sum >= M) {
                ans = height;
                min = height + 1;
            }else{
                max = height - 1;
            }
        }

        System.out.println(ans);
    }
}
