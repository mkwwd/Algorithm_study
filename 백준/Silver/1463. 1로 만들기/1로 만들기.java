import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] save = new int[N+1];
		
		for(int i=2; i<=N; i++) {
			
			save[i] = save[i-1] + 1;
			
			if(i%2 == 0) save[i] = Math.min(save[i], save[i/2]+1);
			if(i%3 == 0) save[i] = Math.min(save[i], save[i/3]+1);
		}
		
		System.out.println(save[N]);
	}

}