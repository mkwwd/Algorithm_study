import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int dx[] = {1,1,1}, dy[] = {-1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int sticker[][] = new int[N+1][3];
        int max[][] = new int[N+1][3];
        int min[][] = new int[N+1][3];

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                sticker[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<N+1; i++){
            max[i][0] += Math.max(max[i-1][0], max[i-1][1]) + sticker[i][0];
            max[i][1] += Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + sticker[i][1];
            max[i][2] += Math.max(max[i-1][1], max[i-1][2]) + sticker[i][2];

            min[i][0] += Math.min(min[i-1][0], min[i-1][1]) + sticker[i][0];
            min[i][1] += Math.min(Math.min(min[i-1][0],min[i-1][1]), min[i-1][2]) + sticker[i][1];
            min[i][2] += Math.min(min[i-1][1], min[i-1][2]) + sticker[i][2];
        }

        int minSticker = Integer.MAX_VALUE;
        int maxSticker = 0;

        for(int i=0; i<3; i++){
            maxSticker = Math.max(maxSticker, max[N][i]);
            minSticker = Math.min(minSticker, min[N][i]);
        }

        System.out.println(maxSticker+" "+minSticker);

    }


}
