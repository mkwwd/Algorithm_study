import java.util.*;
public class Main {

    static int choose[];
    static int answer = 20*1000;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }

        choose = new int[2*n];
        
        Combination(arr, 0, 0);

        System.out.println(answer);
    }

    public static void Combination(int[] arr, int st, int cnt){

        if(cnt == n){
            int sumA = 0;
            int sumB = 0;
            for(int i=0; i<choose.length; i++){
                if(choose[i] == 1){
                    sumA += arr[i];
                }else{
                    sumB += arr[i];
                }
            }
            int gap = Math.abs(sumA - sumB);
            answer = Math.min(answer, gap);
            return;
        }

        for(int i=st; i<arr.length; i++){
            choose[i] = 1;
            Combination(arr, i+1, cnt+1);
            choose[i] = 0;
        }
    }
}