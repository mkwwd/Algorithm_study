import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            // 낮은 순
            TreeMap<Integer, Integer> tm = new TreeMap<>();

            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                String input = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(input.equals("I")){
                    tm.put(num, tm.getOrDefault(num, 0) +1);
                }else if(input.equals("D")){
                    // 최솟값
                    if(tm.isEmpty()) continue;
                    if(num == -1){
                        int min = tm.firstKey();
                        int cnt = tm.get(min);
                        if(cnt == 1) {
                            tm.remove(min);
                        }else {tm.put(min, cnt-1);};
                    }else if(num == 1){ //최댓값
                        int max = tm.lastKey();
                        int cnt = tm.get(max);
                        if(cnt == 1) {
                            tm.remove(max);
                        }else {tm.put(max, cnt-1);};
                    }
                }
            }

            if(tm.isEmpty()){
                sb.append("EMPTY\n");
            }else{
                sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
