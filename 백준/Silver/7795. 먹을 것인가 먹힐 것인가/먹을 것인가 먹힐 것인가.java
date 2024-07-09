import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int [] arrA = new int[a];
            int [] arrB = new int[b];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<a; j++){
                arrA[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<b; j++){
                arrB[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            int indexA = 0;
            int indexB = 0;
            int cnt = 0;

            while(true){
                if(indexA == a || indexB == b) break;
                if(arrA[indexA] > arrB[indexB]){
                    indexB ++;
                    cnt += a - indexA;
                }else{
                    indexA++;
                }
            }

            System.out.println(cnt);
        }

    }
}
