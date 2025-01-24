import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int indegree[] = new int[N+1];
        ArrayList<ArrayList<Integer>> book = new ArrayList<>();

        for(int i=0; i<N+1; i++){
            book.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            indegree[second] ++;
            book.get(first).add(second);
        }

        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i=1; i<N+1; i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }

        while(!que.isEmpty()){
            int now = que.poll();
            sb.append(now).append(" ");
            for(int next : book.get(now)){
                indegree[next] -- ;
                if(indegree[next] == 0){
                    que.add(next);
                }
            }
        }

        System.out.println(sb);

    }

}
