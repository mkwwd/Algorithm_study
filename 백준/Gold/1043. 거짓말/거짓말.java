import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int parent[];
    static ArrayList<Integer> truth;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());

        if(know == 0) {
            System.out.println(M);
            return;
        }

        truth = new ArrayList<>();

        for(int i=0; i<know; i++){
            int who = Integer.parseInt(st.nextToken());
            truth.add(who);
        }

        parent = new int[N+1];
        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }

        ArrayList<ArrayList<Integer>> party = new ArrayList<>();

        for(int i=0; i<M; i++){
            party.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            party.get(i).add(first);
            for(int j=0; j<size-1; j++){
                int next = Integer.parseInt(st.nextToken());
                party.get(i).add(next);
                union(first, next);
            }
        }

        int cnt = 0;
        for(ArrayList<Integer> group: party){
            boolean poss = true;
            for(int person : group){
                if(truth.contains(find(person))){
                    poss = false;
                    break;
                }
            }
            if(poss) cnt++;
        }

        System.out.println(cnt);

    }

    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(truth.contains(pb)){
            int tmp = pa;
            pa = pb;
            pb = tmp;
        }
        parent[pb] = pa;
    }

    static int find(int a){
        if(parent[a] == a) return parent[a];
        return find(parent[a]);
    }

}
