import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> bridge = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            bridge.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            bridge.get(from).add(new int[]{to, value});
            bridge.get(to).add(new int[]{from, value});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        pq.add(new int[] {start, 1000000});

        int gold[] = new int[N+1];
        gold[start] = 1000000;
        int result = 0;

        while(!pq.isEmpty()){
            int now[] = pq.poll();
            if(now[0] == end){
                result = now[1];
                break;
            }

            if(gold[now[0]] > now[1]) continue;

            for(int next[] : bridge.get(now[0])){
                if(gold[next[0]] < Math.min(now[1], next[1])){
                    gold[next[0]] = Math.min(now[1], next[1]);
                    pq.add(new int[] {next[0], gold[next[0]]});
                }
            }
        }

        System.out.println(result);
    }

}
