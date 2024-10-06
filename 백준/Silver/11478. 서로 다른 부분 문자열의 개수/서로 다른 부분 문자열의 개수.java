import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        Set<String> set = new HashSet<>();

        // 0번 인덱스부터
        for(int i=0; i<S.length(); i++){
            for(int j=i+1; j<=S.length(); j++){
                set.add(S.substring(i, j));
            }
        }

        System.out.println(set.size());

    }
}
