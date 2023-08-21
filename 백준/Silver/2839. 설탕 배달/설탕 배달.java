import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sugar = Integer.parseInt(br.readLine());
		
		int T = sugar/5;
		int answer = -1;
		
		for(int i=T; i>=0; i--) {
			int last = sugar - 5*i;
			answer = i;
			if(last == 0) {
				break;
			}
			int mini = last%3;
			if(mini == 0) {
				answer += last/3;
				break;
			}
			else { answer = -1; }
		}
		
		System.out.println(answer);

	}

}