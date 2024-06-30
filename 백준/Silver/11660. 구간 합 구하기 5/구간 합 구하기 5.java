import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] arr = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                // 행 기준으로 더하기
                arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        // m번 계산하기
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int stX = Integer.parseInt(st.nextToken());
            int stY = Integer.parseInt(st.nextToken())-1;
            int edX = Integer.parseInt(st.nextToken());
            int edY = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int j = stX; j<=edX; j++){
                sum = sum + (arr[j][edY] - arr[j][stY]);
            }
           sb.append(sum+ "\n");
        }
        System.out.print(sb);
    }
}
