import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int angle[] = new int[3];
			
			angle[0] = Integer.parseInt(st.nextToken());
			angle[1] = Integer.parseInt(st.nextToken());
			angle[2] = Integer.parseInt(st.nextToken());
			
			if(angle[0] == 0) break;
			
			Arrays.sort(angle);
			
			if(angle[2]*angle[2] == angle[0]*angle[0] + angle[1]*angle[1]){
				System.out.println("right");					
			}
			else {
				System.out.println("wrong");					
			}	
		}

	}
}