import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = sc.nextInt();
        
        int[] cnt = new int[m+1];

        for(int i=1; i<m+1; i++){
            cnt[i] = Integer.MAX_VALUE;
            for(int j=0; j<n; j++){
                int type = coin[j];
                if(type == i){
                    cnt[i] = 1;
                    break;
                }
                if(i - type < 0) continue;
                if(cnt[i-type] != Integer.MAX_VALUE){
                    cnt[i] = Math.min(cnt[i], cnt[i-type] + 1);
                }
            }
        }

        int answer = 0;

        if(cnt[m] == Integer.MAX_VALUE){
            answer = -1;
        }else{
            answer = cnt[m];
        }

        System.out.println(answer);
    }
}