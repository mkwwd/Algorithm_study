import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> road = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            road.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            road.get(from).add(to);
        }

        int dis[] = new int[N+1];
        Arrays.fill(dis, 300001);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] {X, 0});
        dis[X] = 0;

        while(!pq.isEmpty()){
            int now[] = pq.poll();
            if(dis[now[0]] < now[1]) continue;
            for(int next : road.get(now[0])){
                if(dis[next] > now[1] + 1){
                    dis[next] = now[1] + 1;
                    pq.add(new int[] {next, dis[next]});
                }
            }
        }

        int result = 0;

        for(int i=1; i<N+1; i++){
            if(dis[i] == K) {
                result++;
                sb.append(i).append("\n");
            }
        }

        if(result == 0){
            System.out.println(-1);
        }else{
            System.out.println(sb);
        }

    }

}
