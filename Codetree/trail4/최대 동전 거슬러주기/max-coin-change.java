import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];

        int cnt[] = new int[m+1];

        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        cnt[0] = 0;

        for(int i=1; i<m+1; i++){
            cnt[i] = -1;
            for(int j=0; j<n; j++){
                int type = coin[j];
                if(i - type < 0) continue;
                if(cnt[i - type] != -1){
                    cnt[i] = Math.max(cnt[i], cnt[i-type] + 1);
                }
            }
        }

        System.out.println(cnt[m]);
    }
}