import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        HashMap<Integer, Integer> cnt = new HashMap<>();

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            answer += cnt.getOrDefault(k-num, 0);

            cnt.put(num, cnt.getOrDefault(num, 0)+1);
        }
        
        System.out.println(answer);
    }
}