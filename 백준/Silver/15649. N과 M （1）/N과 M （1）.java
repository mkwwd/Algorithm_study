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
		
		pr(0);
		
	}
	
	public static void pr(int cnt) {
		
		if(cnt == M) {
			for(int j=0; j<numbers.length; j++) {
				System.out.print(numbers[j]+" ");
			}
			System.out.println("");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			pr(cnt+1);
			isSelected[i] = false;		
		}
	}
}