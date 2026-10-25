import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        

        for(int i=0; i<n; i++){
            for(int j=n-1; j>=0; j--){
                if(i==0 && j==n-1) continue;
                int top = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if(i != 0){
                    top = matrix[i-1][j];
                }
                if(j != n-1){
                    right = matrix[i][j+1];
                }
                
                matrix[i][j] += Math.min(top, right);
                
            }
        }

        System.out.println(matrix[n-1][0]);
    }
}