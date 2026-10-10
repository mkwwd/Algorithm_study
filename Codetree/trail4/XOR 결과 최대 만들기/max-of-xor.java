import java.util.*;

public class Main {

    public static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        
        Deque<Integer> choose = new ArrayDeque<>();

        getNum(A, choose, 0, m);

        System.out.println(max);
    }

    public static void getNum(int[] A, Deque<Integer> choose, int st, int m){

        if(choose.size() == m){
            int answer = choose.poll();
            choose.add(answer);
            for(int i=0; i<m-1; i++){
                int now = choose.poll();
                answer = answer^now;
                choose.add(now);
            }
            max = Math.max(answer, max);
            return;
        }
        
        for(int i=st; i<A.length; i++){
            choose.add(A[i]);
            getNum(A, choose, i+1, m);
            choose.pollLast();
        }

    }
}