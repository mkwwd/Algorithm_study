import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, answer;
    static int region[];
    static boolean use[];
    static ArrayList<ArrayList<Integer>> info = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        region = new int[N+1];
        use = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            region[i] = Integer.parseInt(st.nextToken());
        }

        // 구역 정보 체크
        for(int i=0; i<N+1; i++){
            info.add(new ArrayList<>());
        }

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            for(int j=0; j<node; j++){
                int next = Integer.parseInt(st.nextToken());
                info.get(i).add(next);
            }
        }

        answer = Integer.MAX_VALUE;

        for(int i=1; i<N/2 + 1; i++){
            combination(1, 0, i);
        }

        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }


    }


    public static void combination(int st, int cnt, int len){

        if(cnt == len){
            HashSet<Integer> groupA = new HashSet<>();
            HashSet<Integer> groupB = new HashSet<>();
            int sumA = 0;
            int sumB = 0;

            for(int i=1; i<N+1; i++){
                if(use[i]){
                    groupA.add(i);
                    sumA += region[i];
                }else{
                    groupB.add(i);
                    sumB += region[i];
                }
            }

            if(checkUnion(groupA)&& checkUnion(groupB)){
                int gap = Math.abs(sumA - sumB);
                answer =Math.min(answer, gap);
            }

            return;
        }

        for(int i=st; i<N+1; i++){
            use[i] = true;
            combination(i+1, cnt+1, len);
            use[i] = false;
        }

    }

    private static boolean checkUnion(HashSet<Integer> group) {

        Deque<Integer> que = new ArrayDeque<>();
        que.add(group.iterator().next());

        while(!que.isEmpty()){
            int now = que.poll();
            group.remove(now);
            for(int next : info.get(now)){
                if(group.contains(next)){
                    que.add(next);
                    group.remove(next);
                }
            }
        }

        if(group.isEmpty()) return true;
        return false;
    }

}
