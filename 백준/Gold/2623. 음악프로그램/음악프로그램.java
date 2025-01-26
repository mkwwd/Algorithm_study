import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int indegree[] = new int[N+1];
        ArrayList<ArrayList<Integer>> singer = new ArrayList<>();

        for(int i=0; i<N+1; i++){
            singer.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            for(int j=0; j<num-1; j++){
                int to = Integer.parseInt(st.nextToken());
                singer.get(from).add(to);
                indegree[to] ++;
                from = to;
            }
        }

        Deque<Integer> que = new ArrayDeque<>();

        for(int i=1; i<N+1; i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }

        boolean check[] = new boolean[N+1];
        int cnt = 0;
        while(!que.isEmpty()){
            int now = que.poll();
            if(check[now]) continue;
            sb.append(now).append("\n");
            check[now] = true;
            cnt++;
            for(int next : singer.get(now)){
                if(check[next]) continue;
                indegree[next]--;
                if(indegree[next] == 0){
                   que.add(next);
                }
            }
        }

        if(cnt == N){
            System.out.println(sb);
        }else{
            System.out.println("0");
        }

    }

}
