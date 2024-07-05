import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] square = new int[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                square[i][j]=str.charAt(j)-'0';
            }
        }

       int min = Math.min(n,m);
        int stop = 0;

        while(min > 1){
            for(int i=0; i<=n-min; i++){
                if(stop==1) break;
                for(int j=0; j<=m-min; j++){
                    int now = square[i][j];
                    if(now==square[i+min-1][j]&&now==square[i][j+min-1]&&now==square[i+min-1][j+min-1]){
                        stop = 1;
                        break;
                    }
                }
            }
            if(stop==1) break;
            min--;
        }

        System.out.println(min*min);

    }
}
