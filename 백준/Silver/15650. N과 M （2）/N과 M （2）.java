import java.util.Scanner;

class Main {
    
	static boolean[] isSelected;
	static int M, N, numbers[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[M];
		isSelected = new boolean[N+1];
		
		pr(0, 1);
		
	}
	
	public static void pr(int cnt, int start) {
		
		if(cnt == M) {
			for(int j=0; j<numbers.length; j++) {
				System.out.print(numbers[j]+" ");
			}
			System.out.println("");
			return;
		}
		
		for(int i=start; i<=N; i++) {
			numbers[cnt] = i;
			pr(cnt+1, i+1);
		}
	}
}