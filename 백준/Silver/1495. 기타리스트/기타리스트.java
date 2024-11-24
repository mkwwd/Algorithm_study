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
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int list[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int volume[] = new int[M+1];

        Arrays.fill(volume, -1);
        volume[S] = 0;

        for(int i=1; i<=N; i++){
            ArrayList<Integer> music = new ArrayList<>();
            for(int j=0; j<=M; j++){
                if(volume[j] == i-1){
                    int up = j + list[i-1];
                    if(up <= M){
                        music.add(up);
                    }
                    int down = j - list[i-1];
                    if(down >=0){
                        music.add(down);
                    }
                }
            }

            for(int v : music){
                volume[v] = i;
            }
        }

        int max = -1;
        for(int i=0; i<=M; i++){
            if(volume[i] == N){
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }

}
