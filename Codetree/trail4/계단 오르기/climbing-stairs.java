import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int stairs[] = new int[n+1];

        stairs[2] = 1;
        if(n > 2) stairs[3] = 1;

        for(int i=4; i<n+1; i++){
            stairs[i] = (stairs[i-2] + stairs[i-3])%10007;
        }

        System.out.println(stairs[n]);
    }
}