import javax.swing.text.Style;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 보석 무게 순으로 오름차순 정렬하기
        int gem[][] = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            gem[i][0] = Integer.parseInt(st.nextToken());
            gem[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(gem, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int bag[] = new int[K];
        for(int i=0; i<K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);

        // 가방 수 많큼 넣어줄 pq 생성, 가치 순으로 정렬
        PriorityQueue<Integer> steal =  new PriorityQueue<>(Comparator.reverseOrder());

        int index = 0;
        long answer = 0;

        for(int i=0; i<K; i++){
            int weight = bag[i];
            // 제일 무게 작은 보석부터 돔
            while(index < N){
                // 넣을 수 있는데까지 넣음
                if(weight >= gem[index][0]){
                    steal.add(gem[index][1]);
                    index++;
                }else{
                    break;
                }
            }
            // 넣을 수 있는 것중에 가장 가치 큰 것 넣음
            if(!steal.isEmpty()){
                answer += steal.poll();
            }
        }

        System.out.print(answer);
    }


}
