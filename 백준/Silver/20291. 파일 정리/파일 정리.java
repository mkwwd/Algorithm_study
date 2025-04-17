import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> tree = new TreeMap<>();

        for(int i=0; i<N; i++){
            String str[] = br.readLine().split("\\.");
            tree.put(str[1], tree.getOrDefault(str[1], 0) + 1 );
        }

        for(Map.Entry<String, Integer> entry : tree.entrySet()){
            sb.append(entry.getKey()+ " ").append(entry.getValue() + "\n");
        }

        System.out.println(sb);
    }

}
