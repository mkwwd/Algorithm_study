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

        // 문자열의 길이 1부터 S전체
        for(int i=1; i<=S.length(); i++){
            for(int j=0; j<S.length()-i+1; j++){
                set.add(S.substring(j, j+i));
            }
        }

        System.out.println(set.size());

    }
}
