import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int number[] = new int[N];
        int palindrome[][] = new int[N][N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<=i; j++){
                if(i==j) {
                    palindrome[i][j] = 1;
                    continue;
                }

                if(i-j+1 > 2){
                    if(number[i] == number[j] && palindrome[j+1][i-1] == 1){
                        palindrome[j][i] = 1;
                    }
                }else{
                    if(number[i] == number[j]) palindrome[j][i] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0 ;i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            if(palindrome[from][to] == 1){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);

    }

}
