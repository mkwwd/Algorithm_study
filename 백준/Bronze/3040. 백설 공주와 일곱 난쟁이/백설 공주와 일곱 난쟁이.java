import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	private static int dwarf[], noDwarf[], gap, stop;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		dwarf = new int[9];
		noDwarf = new int[2];
		int hatSum = 100;
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum += dwarf[i];		
		}
		
		gap = sum - hatSum;
		stop = 0;
		findNoDwarf(0, 0);
		
		for(int i=0; i<9; i++) {
			int isDwarf = dwarf[i];
			if(isDwarf != noDwarf[0] && isDwarf != noDwarf[1]) {
				System.out.println(isDwarf);
			}
		}
	}
	
	private static void findNoDwarf(int cnt, int start) {
			
		if(cnt == 2) {
			if(noDwarf[0] + noDwarf[1] == gap) {
				stop = -1;
				return;
			};
			return;
		}
		for(int i=start; i<9; i++) {
			if(stop == -1) break;
			noDwarf[cnt] = dwarf[i];
			findNoDwarf(cnt+1, i+1);
		}
		
	}
}
