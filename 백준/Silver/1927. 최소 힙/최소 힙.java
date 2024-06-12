import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N ;i++){
            int input = Integer.parseInt(br.readLine());

            if(input == 0){
                if(pq.size() == 0){
                    sb.append("0"+ "\n");
                }else{
                    sb.append(pq.poll()+ "\n");
                }
            }else{
                pq.add(input);
            }
        }

        System.out.println(sb);
    }
}
