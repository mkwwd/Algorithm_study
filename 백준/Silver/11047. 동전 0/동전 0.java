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

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> coin = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            coin.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;

        while(K > 0){
            int money = coin.pollLast();
            if(money > K) continue;
            cnt += K/money;
            K = K%money;
        }

        System.out.println(cnt);
    }
}
