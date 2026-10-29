import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int dp[] = new int[n];
        int max = 0;

        for(int i=0; i<n; i++){
            max = Math.max(max, dp[i]);
            int jump = arr[i];
            if(jump == 0) continue;
            if(i != 0 && dp[i] == 0) continue;
            for(int j=1; j<=jump; j++){
                if(i+j >= n) continue;
                dp[i+j] = Math.max(dp[i+j] , dp[i]+1);
            }
        }

        System.out.println(max);
    }
}