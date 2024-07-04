import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;

        while(pq.size() != 0){
            if (pq.size() == 1) break;
            int a = pq.poll();
            int b = pq.poll();
            sum  += a+b;
            pq.add(a+b);
        }

        System.out.println(sum);

    }
}
