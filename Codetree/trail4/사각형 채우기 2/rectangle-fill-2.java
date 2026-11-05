import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int square[] = new int[1001];

        square[1] = 1;
        square[2] = 3;

        for(int i=3; i<n+1; i++){
            square[i] = (square[i-1] + square[i-2] * 2)%10007;
        }

        System.out.println(square[n]);
    }
}