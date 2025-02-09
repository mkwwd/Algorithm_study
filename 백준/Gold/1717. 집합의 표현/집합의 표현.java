import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int parent[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(input == 0){
                union(from, to);
            }else{
                int pfrom = find(from);
                int pto = find(to);
                if(pfrom == pto){
                    sb.append("YES").append("\n");
                }else{
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.println(sb);

    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa != pb){
            parent[pa] = pb;
        }
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x]  = find(parent[x]);
    }

}
