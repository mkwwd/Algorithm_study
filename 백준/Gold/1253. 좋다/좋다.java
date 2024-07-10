import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [] num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        int cnt = 0;
        for(int i=0; i<N; i++){
            int left = 0;
            int right  = N-1;
            while(left<right){
                if(left == i){
                    left ++;
                }else if(right == i){
                    right --;
                }else{
                    if(num[left] + num[right] > num[i]){
                        right--;
                    }else if(num[left] + num[right] < num[i]){
                        left++;
                    }else{
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);

    }
}
