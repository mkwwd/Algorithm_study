import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String next = sc.next();
            hash.put(next, hash.getOrDefault(next, 0) + 1);
        }

        int max = Collections.max(hash.values());

        System.out.println(max);   

    }
}