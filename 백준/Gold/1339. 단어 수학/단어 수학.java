import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[26];

        for(int i=0; i<N; i++){
            String word = br.readLine();
            for(int j=0; j<word.length(); j++){
                char c = word.charAt(j);
                arr[c-'A'] += (int)Math.pow(10, word.length() -j -1);
            }
        }

        Arrays.sort(arr);

        int num = 9;
        int answer = 0;
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] == 0) break;
            answer += arr[i]*num;
            num--;
        }

        System.out.println(answer);

    }

}
