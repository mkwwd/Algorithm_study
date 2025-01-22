import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] forest, dp;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        forest = new int[N][N];
        dp = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                ans = Math.max(ans, DFS(i,j));
            }
        }

        System.out.println(ans);
    }

    public static int DFS(int x, int y) {

        if(dp[x][y] != 0){
            return dp[x][y];
        }

        dp[x][y] = 1;

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX < 0 || newX >= N || newY < 0 || newY >= N) continue;

            if(forest[newX][newY] > forest[x][y]){
                dp[x][y] = Math.max(dp[x][y], DFS(newX, newY) + 1);
            }
        }

        return dp[x][y];

    }

}
