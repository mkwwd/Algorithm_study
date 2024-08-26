import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, parent[];
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];

        for(int i=0; i<N+1; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(1);

        for(int i=2; i<N+1; i++){
            sb.append(parent[i]+"\n");
        }

        System.out.println(sb);

    }

    private static void dfs(int pa) {

        for(int i=0; i<list.get(pa).size(); i++){
            int node = list.get(pa).get(i);
            if(parent[node] == 0){
                parent[node] = pa;
                dfs(node);
            }
        }
    }

}
