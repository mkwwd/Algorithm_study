import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] pa = new int[S];
        long sum = 0;
        long max = 0;

        for(int i=0; i<S; i++){
            pa[i] = Integer.parseInt(br.readLine());
            sum += pa[i];
            max = Math.max(max, pa[i]);
        }

        long min = 1;
        long mid = 0;

        while(min<=max){
            mid = (min + max)/2;
            int cnt = 0;
            for(int i=0; i<S; i++){
                cnt += pa[i]/mid;
            }
            if(cnt >= C){
                min = mid+1;
            }else{
                max = mid-1;
            }
        }

        long ans = sum - (max)*C;

        System.out.println(ans);

    }

}
