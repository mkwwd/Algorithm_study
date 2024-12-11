import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String bomb = br.readLine();
        int blen = bomb.length();

        for(int i=0; i<str.length(); i++){
            sb.append(str.charAt(i));
            if(sb.length() >= blen && str.charAt(i) == bomb.charAt(blen-1)){
                if(sb.substring(sb.length()-blen).equals(bomb)){
                    sb.delete(sb.length()-blen, sb.length());
                }
            }
        }

        if(sb.length() == 0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }

    }

}
