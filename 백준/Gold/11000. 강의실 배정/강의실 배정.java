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
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int sub[][] = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            sub[i][0] = Integer.parseInt(st.nextToken());
            sub[i][1] = Integer.parseInt(st.nextToken());
        }

        // 강의 시작시간 오름차순 청렬
        Arrays.sort(sub, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 시작 시간이 같으면 끝나는 시간 오름차순 정렬
                if(o1[0] == o2[0]) return o1[1] -o2[1];
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 가장 빨리 끝나는 시간 넣어주기
        pq.add(sub[0][1]);

        for(int i=1; i<N; i++){
            int fin = pq.peek();
            // 시작시작이 끝나는 시간보다 크거나 같으면 강은 강의실 사용이 가능하므로 빼고 새로 끝나는 시간 넣음
            if(sub[i][0] >= fin){
                pq.poll();
            }
                pq.add(sub[i][1]);
        }

        System.out.println(pq.size());

    }

}
