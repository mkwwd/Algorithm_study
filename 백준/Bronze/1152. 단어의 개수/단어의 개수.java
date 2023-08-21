import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inputs[] = br.readLine().split(" ");
		int count = 0;
		
		for(int i=0; i<inputs.length; i++) {
			if(!inputs[i].equals("")) count++;
		}
		
		System.out.println(count);
	}
}
