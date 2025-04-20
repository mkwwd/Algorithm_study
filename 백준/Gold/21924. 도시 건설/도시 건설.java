import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long maxPrice = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[2]-o2[2];
            }
        });

        HashSet<Integer> building = new HashSet<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            pq.add(new int[] {from, to, value});
            building.add(from);
            building.add(to);
            maxPrice += value;
        }

        parent = new int[N+1];
        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }

        long value = 0;

        while(!pq.isEmpty()){

            int[] now = pq.poll();
            if(find(now[0]) == find(now[1])) continue;
            // 다르면 두개 연결해줌
            union(now[0], now[1]);
            value += now[2];

        }

        long answer = maxPrice - value;

        for(int i=1; i<N; i++){
            if(find(i) != find(i+1)){
                answer = -1;
                break;
            }
        }

        System.out.println(answer);

    }

    public static int find(int node){
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa < pb){
            parent[pb] = pa;
        }else{
            parent[pa] = pb;
        }
    }

}
