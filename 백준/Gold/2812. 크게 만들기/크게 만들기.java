import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int len = N-K;

        String input = br.readLine();
        int num[] = new int[N];
        for(int i=0; i<input.length(); i++){
            num[i] = input.charAt(i) - '0';
        }

        Deque<Integer> que = new ArrayDeque<>();
        for(int i=0; i<num.length; i++){
            if(!que.isEmpty()){
                while(!que.isEmpty() && K>0 && que.peekLast() < num[i]){
                    que.pollLast();
                    K--;
                }
            }

            que.add(num[i]);
        }

        for(int i=0; i<len; i++){
            sb.append(que.poll());
        }

        System.out.println(sb);

    }

}
