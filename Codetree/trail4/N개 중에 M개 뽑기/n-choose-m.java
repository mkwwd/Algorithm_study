import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int choose[] = new int[n];

        Combination(choose, 0, 0, m);
    }

    public static void Combination(int choose[], int st, int cnt, int m){

        if(cnt == m){
            for(int i=0; i<choose.length; i++){
                if(choose[i] == 1){
                    System.out.print(i+1+" ");
                }
            }
            System.out.println();
            return;
        }

        for(int i=st; i<choose.length; i++){
            choose[i] = 1;
            Combination(choose, i+1, cnt+1, m);
            choose[i] = 0;
        }
    }
}