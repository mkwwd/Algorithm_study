import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,K;
    static int cnt = 0;
    static int arr[] = new int[11];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        find(0 , 0);

        if(cnt < K){
            System.out.println("-1");
        }else{
            System.out.println(sb);
        }

    }

    static void find(int sum, int now){

        if(sum > N) return;

        if(sum == N){
            cnt++;
            if(cnt == K){
                for(int i=0; i<now-1; i++){
                    sb.append(arr[i]+"+");
                }
                sb.append(arr[now-1]);
            }
            return;
        }

        for(int i=1; i<=3; i++){
            arr[now] = i;
            find(sum + i, now+1);
        }
    }
}
