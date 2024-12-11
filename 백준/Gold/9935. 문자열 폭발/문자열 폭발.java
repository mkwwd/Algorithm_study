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
            if(sb.length() >= bomb.length() && str.charAt(i) == bomb.charAt(bomb.length()-1)){
                String last = "";
                for(int j=0; j<blen; j++){
                    last += sb.charAt(sb.length() - blen + j);
                }
                if(last.equals(bomb)){
                    for(int j=0; j<blen; j++){
                        sb.deleteCharAt(sb.length()-1);
                    }
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
