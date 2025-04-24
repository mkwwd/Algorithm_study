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

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            arr.add(new ArrayList<>());
        }

        int[] subject = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr.get(to).add(from);
        }

        for(int i=1; i<N+1; i++){
            if(arr.get(i).isEmpty()){
                subject[i] = 1;
            }else{
                int max = 0;
                for(int next : arr.get(i)){
                    max = Math.max(max, subject[next] + 1);
                }
                subject[i] = max;
            }

            sb.append(subject[i]+" ");
        }

        System.out.println(sb);

    }

}
