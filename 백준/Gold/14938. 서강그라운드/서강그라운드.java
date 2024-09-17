import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int items[] = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        int dis[][] = new int[N+1][N+1];
        for(int i=1; i<N+1; i++){
            Arrays.fill(dis[i], 1000);
            dis[i][i] = 0;
        }

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            dis[start][end] = value;
            dis[end][start] = value;
        }

        // 플로이드 워셜로 현 정점으로부터 다른 정점까지의 최단 거리를 구하기
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                for(int k=1; k<N+1; k++){
                    if(dis[j][k] > dis[j][i]+dis[i][k]){
                        dis[j][k] = dis[j][i]+dis[i][k];
                    }
                }
            }
        }

        // 각 정점에서 시작했을 때 얻을 수 있는 아이템의 수 구하기
        int max = 0;
        for(int i=1; i<N+1; i++){
            int sum = 0;
            for(int j=1; j<N+1; j++){
                if(dis[i][j] <= M){
                    sum += items[j];
                }
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);

    }

}
