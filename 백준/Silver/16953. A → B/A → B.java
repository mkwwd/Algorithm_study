import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        int ans = 0;
        int poss = -1;

        Deque<Long> que = new ArrayDeque<>();
        que.add(A);

        while(!que.isEmpty()){

            int size = que.size();
            for(int i=0; i<size; i++){
                long num = que.poll();
                if(num == B) {
                    poss = 0;
                    que.clear();
                    break;
                }if(num<B){
                    que.add(num *2);
                    que.add(num*10+1);
                }
            }
            ans ++;
        }

        if(poss == -1){
            System.out.println(poss);
        }else{
            System.out.println(ans);
        }

    }


}
