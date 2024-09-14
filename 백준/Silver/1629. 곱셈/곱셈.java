import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static long c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        long ans = mul(a, b);

        System.out.println(ans);
    }

    private static long mul(long a, long b) {

        if(b == 1){
            return a % c;
        }

        // 절반에 해당하는 값
        long half = mul(a, b/2);

        // 홀수
        if(b%2 == 1){
            return (half*half%c)*a%c;
        }
        return half*half%c;
    }
}
