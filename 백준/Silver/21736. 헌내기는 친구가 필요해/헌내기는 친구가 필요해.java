import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static char campus[][];
    static int N, M, startX, startY;
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];

        for(int i=0; i<N ; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                char a = input.charAt(j);
                campus[i][j] = a;
                if(a == 'I'){
                    startX = i;
                    startY = j;
                }
            }
        }

        int cnt = findPersion();

        if(cnt == 0){
            System.out.println("TT");
        }else{
            System.out.println(cnt);
        }

    }

    private static int findPersion() {
        Deque<int[]> que = new ArrayDeque<>();
        boolean check[][] = new boolean[N][M];
        check[startX][startY] = true;
        que.add(new int[] {startX, startY});
        int cnt = 0;
        while (!que.isEmpty()){
            int now[] = que.poll();
            int nowX = now[0];
            int nowY = now[1];
            for(int i=0; i<4; i++){
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                if(newX < 0 || newX >=N || newY <0 || newY >=M) continue;
                if(check[newX][newY]) continue;
                check[newX][newY] = true;
                if(campus[newX][newY] == 'X') continue;
                if(campus[newX][newY] == 'P'){
                    cnt ++;
                }
                que.add(new int[] {newX, newY});
            }
        }

        return cnt;
    }

}
