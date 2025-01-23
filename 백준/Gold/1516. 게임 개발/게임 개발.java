import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> building = new ArrayList<>();

        for(int i=0; i<=N; i++){
            building.add(new ArrayList<>());
        }

        int[] indegree = new int[N+1];
        int[] time = new int[N+1];
        int[] result = new int[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true){
                int num = Integer.parseInt(st.nextToken());
                if(num == -1) break;

                building.get(num).add(i);
                indegree[i] ++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i] == 0){
                queue.add(i);
                result[i] = time[i];
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : building.get(now)){
                indegree[next] --;
                result[next] = Math.max(result[next], result[now] + time[next]);
                if(indegree[next] == 0){
                    queue.add(next);
                }
            }
        }

        for(int i=1; i<=N; i++){
            sb.append(result[i]).append("\n");
        }
        
        System.out.println(sb);

    }

}
