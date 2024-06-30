import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int type, total;
    static int com[];
    static TreeMap<String, Integer> tm;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T ;i++){
            int N = Integer.parseInt(br.readLine());
            tm = new TreeMap<>();
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if(tm.getOrDefault(b, -1) == -1){
                    tm.put(b, 1);
                }else{
                    tm.put(b, tm.getOrDefault(b, 0) +1);
                }

            }

            total = 1;
            for (Map.Entry<String, Integer> entry : tm.entrySet()) {
                total *= (entry.getValue()+1);
            }

            total--;
            sb.append(total + "\n");

        }

        System.out.println(sb);

    }

}
