import java.util.Scanner;

public class Main {

    public static int n, cnt;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        
        visited = new boolean[n][n];

        int brick = 0;
        int max = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]) continue;
                visited[i][j] = true;
                cnt = 1;
                dfs(i, j);
                max = Math.max(max, cnt);
                if(cnt >= 4){
                    brick ++;
                }
            }
        }

        System.out.println(brick + " " + max);
    }

    public static void dfs(int x, int y){

        for(int i=0; i<4; i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
            if(grid[nextX][nextY] != grid[x][y]) continue;
            if(visited[nextX][nextY]) continue;
            visited[nextX][nextY] = true;
            cnt ++;
            dfs(nextX, nextY);
        }

    }
}