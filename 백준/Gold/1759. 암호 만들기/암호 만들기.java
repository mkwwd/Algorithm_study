import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	
	static char alpha[];
	static char code[];     
	static int L, C;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		alpha = new char[C];
		for(int i=0; i<C; i++) {			
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha);
				
		code = new char[L];
		makeCode(0, 0);

	}

	private static void makeCode(int cnt, int start) {
		
		if(cnt == L) {
			isPossible();
			return;
		}
		
		for(int i=start; i<C; i++) {
			code[cnt] = (char)alpha[i];
			makeCode(cnt+1, i+1);
		}
			
	}

	private static void isPossible() {
		
		int vowel = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<code.length; i++) {
			sb.append(code[i]);
			if(code[i] == 'a' || code[i] == 'e' || code[i] == 'i' || code[i] == 'o' || code[i] == 'u') {
				vowel++;
			}
		}
		
		int last = L - vowel;
		if(1 <= vowel && 2<= last) {
			System.out.println(sb);
		}
		
	}

}