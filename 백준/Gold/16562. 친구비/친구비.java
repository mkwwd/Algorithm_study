import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int parent[], price[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        price = new int[N+1];
        parent = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a > b){
                union(b, a);
            }else{
                union(a, b);
            }
        }

        boolean friend[] = new boolean[N+1];
        int money = 0;
        boolean pos = true;
        for(int i=1; i<N+1; i++){
            int root = find(i);
            if(!friend[root]){
                  if(money + price[root] <= K){
                      money += price[root];
                      friend[root] = true;
                  }else{
                      pos = false;
                      break;
                  }
            }
        }

        if(pos){
            System.out.println(money);
        }else{
            System.out.println("Oh no");
        }

    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(price[pa] > price[pb]){
            parent[pa] = pb;
        }else{
            parent[pb] = pa;
        }
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
