import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int num = Integer.parseInt(br.readLine());
            Deque<Integer> que = new ArrayDeque<>();

            int cnt = 0;
            int add[] = new int []{1,2,3};
            que.add(1);
            que.add(2);
            que.add(3);
            while(!que.isEmpty()){
                int now = que.poll();
                if(now == num) {
                    cnt++;
                    continue;
                }
                for(int j=0; j<3; j++){
                    int sum = now + add[j];
                    if(sum == num) cnt++;
                    if(sum < num) que.add(sum);
                }
            }

            sb.append(cnt+"\n");
        }

        System.out.println(sb);
    }

}
