import javax.swing.text.Style;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeMap<String, Integer> tm = new TreeMap<>();

        for(int i=0; i<N; i++){
            tm.put(br.readLine(), 0);
        }

        int cnt = 0;

        for(int i=0; i<M; i++){
            String input = br.readLine();
            if(tm.getOrDefault(input, -1) != -1){
                cnt ++;
                tm.put(input, 1);
            }
        }

        sb.append(cnt+"\n");

        for (Map.Entry<String, Integer> entry : tm.entrySet()) {
            if(entry.getValue() == 1){
                sb.append(entry.getKey()+"\n");
            }
        }

        System.out.println(sb);

    }
}
