import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	static int noDwarf[], dwarf[], gap, stop = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		PriorityQueue<Integer> que = new PriorityQueue<>();
		dwarf = new int[9];
		noDwarf = new int[2];
		int hSum = 100;
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			que.add(dwarf[i]);
			sum += dwarf[i];
		}

		gap = sum - hSum;
		
		find(0, 0);
		
		for(int i=0; i<9; i++) {
			int isDwarf = que.poll();
			if(isDwarf != noDwarf[0] && isDwarf != noDwarf[1]) {				
				System.out.println(isDwarf);
			}
		}
		
		
	}

	private static void find(int cnt, int start) {
		
		if(cnt == 2) {
			if(noDwarf[0] + noDwarf[1] == gap) {
				stop = -1;
				return;
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			if(stop == -1) break;
			noDwarf[cnt] = dwarf[i];
			find(cnt+1, i+1);
		}
	}

}