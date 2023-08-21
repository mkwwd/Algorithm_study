import java.util.Scanner;

public class Main {
	
	static int[] sw;
	static int[] onoff = {1, 0};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		sw = new int[t];
		
		for(int i=0; i<sw.length; i++){
			sw[i] = sc.nextInt();
		}
		
		int people = sc.nextInt();
		
		for(int i=0; i<people; i++) {
			int stu = sc.nextInt();
			int num = sc.nextInt();
			int j = 1;
			
			if(stu == 1) {
				boy(num, j);
			}
			else{
				sw[num-1] = onoff[sw[num-1]];
				girl(num-1, j);
			}
		}	
		
		int line = t/20;
		int last = t%20;
		int index = 0;
		
		for(int i=0; i<line; i++) {
			for(int j=0; j<20; j++) {
				System.out.print(sw[index++]+" ");
			}
			System.out.println("");
		}
		
		for(int i=0; i<last; i++) {
			System.out.print(sw[index++]+" ");
		}
	}
	
	public static void boy(int num, int j) {
		if(num*j > sw.length) return;
		else {
			sw[num*j-1] = onoff[sw[num*j-1]];
			j ++;
			boy(num, j);
		}	
	}
	
	public static void girl(int num, int j) {
		if(num-j>= 0 && num+j < sw.length ) {
			if(sw[num-j] != sw[num+j]) return;			
			else {
				sw[num-j] = onoff[sw[num-j]];
				sw[num+j] = onoff[sw[num+j]];
				j++;
				girl(num, j);
			}
		}
	}
}