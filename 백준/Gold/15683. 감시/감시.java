import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, min = Integer.MAX_VALUE;
    static int map[][];
    static List<int[]> cctv = new ArrayList<>();

    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    static int[][][] dirs = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0,2}, {1,3}},
            {{0,1}, {1,2}, {2,3}, {3,0}},
            {{0,1,2}, {1,2,3}, {2,3,0}, {3,0,1}},
            {{0,1,2,3}}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0 && map[i][j] < 6){
                    cctv.add(new int[] {i, j, map[i][j]});
                }
            }
        }

        dfs(0, map);

        System.out.println(min);

    }

    public static void dfs(int depth, int[][] board){

        if(depth == cctv.size()){
            countZero(board);
            return;
        }

        int[] getOne = cctv.get(depth);
        int x = getOne[0];
        int y = getOne[1];
        int type = getOne[2];

        for(int[] dirs : dirs[type]){
            int copied[][] = copy(board);
            for(int dir : dirs){
                paint(x, y, dir, copied);
            }
            dfs(depth + 1, copied);
        }

    }

    public static void countZero(int arr[][]){
        int cnt = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 0) cnt ++;
            }
        }

        min = Math.min(min, cnt);
    }

    public static void paint(int x, int y, int dir, int arr[][]){

        while(true){
            x += dx[dir];
            y += dy[dir];

            if(x < 0 || y < 0 || x >= N || y >= M) break;
            if(arr[x][y] == 6) break;

            if(arr[x][y] == 0){
                arr[x][y] = 7;
            }
        }
    }

    public static int[][] copy(int[][] board){
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++){
            copy[i] = board[i].clone();
        }

        return copy;

    }
}
