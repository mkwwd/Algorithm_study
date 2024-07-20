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
        int [] liquid = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        int left = 0;
        int right = N-1;
        int one = 0;
        int two = 0;
        int min = Integer.MAX_VALUE;

        while(left<right){
            int gap = Math.abs(liquid[left] + liquid[right]);
            int sum = liquid[left] + liquid[right];

            if(gap < min){
                min = gap;
                one = left;
                two = right;
            }

            if(sum < 0){
                left ++;
            }else if(sum > 0){
                right--;
            }else{
                one = left;
                two = right;
                break;
            }
        }

        System.out.println(liquid[one]+" "+liquid[two]);

    }
}
