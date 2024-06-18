import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int computer[][] = new int[N+1][N+1];

        for(int i=0; i<C; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            computer[first][second] = 1;
            computer[second][first] = 1;
        }

        boolean check[] = new boolean[N+1];
        Deque<Integer> que = new ArrayDeque<>();

        que.add(1);
        check[1] = true;
        int cnt = 0;

        while(!que.isEmpty()){
            int now = que.poll();
            for(int i=1; i<=N; i++){
                if(computer[now][i] == 1){
                    if(check[i]) continue;
                    check[i] = true;
                    que.add(i);
                    cnt ++;
                }
            }

        }

        System.out.println(cnt);
    }

}
