import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int arr[] = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int answer = 0; 

        for (int i = 1; i < n-1; i++) {
            int prev = arr[i-1];
            cnt.put(prev, cnt.getOrDefault(prev, 0) + 1);

            for(int j = i+1; j<n; j++){
                int t = k - arr[i] - arr[j];
                answer += cnt.getOrDefault(t, 0);
            }
        }

        System.out.println(answer);     
    }
}