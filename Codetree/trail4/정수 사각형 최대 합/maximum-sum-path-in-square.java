import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                matrix[i][j] += Math.max(matrix[i-1][j], matrix[i][j-1]);
            }
        }

        System.out.println(matrix[n][n]);
    }
}