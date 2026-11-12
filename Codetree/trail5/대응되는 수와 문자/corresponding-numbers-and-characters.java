import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, String> hash = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String next = sc.next();
            hash.put(next, Integer.toString(i));
            hash.put(Integer.toString(i), next);
        }
        
        for (int i = 0; i < m; i++) {
            System.out.println(hash.get(sc.next()));
        }
        // Please write your code here.
    }
}