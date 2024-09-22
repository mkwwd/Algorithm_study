import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int start = 301;
        int end = 1130;
        int N = Integer.parseInt(br.readLine());
        int flower[][] = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            flower[i][0] = Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken());
            flower[i][1] = Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken());
        }

        Arrays.sort(flower, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               if(o1[0] == o2[0]) return o1[1] - o2[1];
               return o1[0] - o2[0];
            }
        });

        int index = 0;
        int endDate = 0;
        int ans = 0;
        while(start <= end){
            boolean find = false;
            for(int i=index; i<N; i++){
                // 피는일이 시작일보다 작아야 함
                if(flower[i][0] > start) break;
                // 지는일이 현재보다 크면 선택
                if(flower[i][1] > endDate){
                    find = true;
                    endDate = flower[i][1];
                    index = i+1;
                }
            }
            // find가 false이면 실패
            if(find){
                start = endDate;
                ans ++;
            }else{
                break;
            }
        }

        if(endDate <= end){
            System.out.println(0);
        }else{
            System.out.print(ans);
        }
    }

}
