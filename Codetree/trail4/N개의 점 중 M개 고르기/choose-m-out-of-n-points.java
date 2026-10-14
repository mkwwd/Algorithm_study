import java.util.*;

public class Main {

    public static int m, n;
    public static int[] choose;
    public static int[][] points;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        points = new int[n][2];
        choose = new int[n];

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        
        combination(0, 0);

        System.out.println(min);
    }

    public static void combination(int st, int cnt){

        if(cnt == m){
            int max = 0;
            for(int i=0; i<choose.length; i++){
                if(choose[i] == 0) continue;
                for(int j=i+1; j<choose.length; j++){
                    if(choose[j] == 0) continue;
                    int now = (int)Math.pow(points[j][0] - points[i][0],2) + (int)Math.pow(points[j][1] - points[i][1],2);
                    max = Math.max(max, now);
                }
            }
            min = Math.min(min, max);
            return;
        }

        for(int i=st; i<n; i++){
            choose[i] = 1;
            combination(i+1, cnt+1);
            choose[i] = 0;
        }
    }
}