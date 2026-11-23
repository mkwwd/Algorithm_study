import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int gcd = findgcd(n, m);

        int lcm = n*m/gcd;

        System.out.println(lcm);
    }

    public static int findgcd(int a, int b){
        if(a%b == 0) return b;
        return findgcd(b, a%b);
    }
}