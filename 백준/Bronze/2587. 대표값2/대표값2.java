import java.util.Arrays;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] numbers = new int[5];
		int avg = 0;
		
		for(int i =0; i<5; i++) {
			numbers[i] = sc.nextInt();
			avg += numbers[i];
		}
		
		Arrays.sort(numbers);
		
		System.out.println(avg/5);
		System.out.println(numbers[2]);
		
	}

}