import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int guu[] = new int[9], inn[] = new int[9], newInn[] = new int[9], guuWin, innWin;
	static boolean isSelected[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		boolean[] isguu;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			isguu = new boolean[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				guu[i] = Integer.parseInt(st.nextToken());
				isguu[guu[i]] = true;
			}
			int j=0;
			for(int i=1; i<=18; i++) {
				if(!isguu[i]) inn[j++] = i;
			}
			
			isSelected = new boolean[10];
			
			guuWin = 0;
			innWin = 0;
			cardSelect(0);
			
			System.out.println("#"+test_case+" "+guuWin + " " + innWin);		
		}	
		
	}

	private static void cardSelect(int cnt) {
		
		if(cnt == 9) {
			playGame(newInn);
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(isSelected[i]) continue;
			newInn[cnt] = inn[i];
			isSelected[i] = true;
			cardSelect(cnt+1);
			isSelected[i] = false;
		}		
	}

	private static void playGame(int[] newInn2) {
		
		int guuScore = 0;
		int InnScore = 0;
		for(int i=0; i<9; i++) {
			if(guu[i] > newInn[i]) {
				guuScore += guu[i] + newInn[i];
			}
			else if(guu[i] < newInn[i]){
				InnScore += guu[i] + newInn[i];
			}
		}
		
		if(guuScore > InnScore) {
			guuWin++;
		}
		else if(guuScore < InnScore) {
			innWin++;
		}		
	}
}