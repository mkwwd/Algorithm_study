import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int block[][] = new int[H][W];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++){
            int b = Integer.parseInt(st.nextToken());
            for(int j=0; j<b; j++){
                block[j][i] = 1;
            }
        }

        int ans = 0;
        for(int i=0; i<H; i++){
            int start = -1;
            for(int j=0; j<W; j++){
                if(block[i][j] == 1 && start == -1){
                    start = j;
                }else if(block[i][j] == 1){
                    int water = j - start -1;
                    ans += water;
                    start = j;
                }
            }
        }

        System.out.println(ans);

    }

}
