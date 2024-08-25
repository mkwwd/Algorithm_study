import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        int ans = 0;

        if(crane.get(0)<box.get(0)){
            System.out.println(-1);
            return;
        }

        while(!box.isEmpty()){

            // 시작위치 체크
            int start = 0;

            // 크레인 체크
            for(int i=0; i<N; i++){

                int size = box.size();
                int move = 0;

                for(int j=start; j<size; j++){
                    // j번째 박스가져오기
                    int nowBox = box.get(j);
                    // 현재 박스가 옮기기 가능이면 옮기고 스탑
                    if(nowBox <= crane.get(i)) {
                        box.remove(j);
                        // 시작위치를 나간위치부터 체크하도록
                        start = j;
                        move++;
                        break;
                    }
                }

                if(move == 0) break;

            }

            ans ++;
        }

        System.out.println(ans);

    }

}
