import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<ArrayList<Integer>> node = new ArrayList<>();

        for(int i=0; i<=n; i++){
            node.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            node.get(from).add(to);
            node.get(to).add(from);
        }
        
        int parent[] = new int[n+1];

        Deque<Integer> que = new ArrayDeque<>();

        que.add(1); 
        parent[1] = 1;

        while(!que.isEmpty()){
            int now = que.poll();
            for(int next: node.get(now)){
                if(parent[next] != 0) continue;
                parent[next] = now;
                que.add(next);
            }
        }

        for(int i=2; i<=n; i++){
            System.out.println(parent[i]);
        }
    }
}