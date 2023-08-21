import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	static int t, s, b;
	static int min =  1000000000;
	static String[][] ingre;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
//		System.out.println(t);
		
		ingre = new String[t][2];
		isSelected = new boolean[t];
		
		for(int i=0; i<t; i++) {
			ingre[i] = br.readLine().split(" ");
		}
		
		cook(0);	
		
		System.out.println(min);
	}
	
	public static void cook(int cnt) {
		
		if(cnt == t) {
			s = 1;
			b = 0;
			for(int i=0; i<t; i++) {
				if(isSelected[i]) {
					s *= Integer.parseInt(ingre[i][0]);
					b += Integer.parseInt(ingre[i][1]);
					min = Math.min(min, Math.abs(s - b));
				}
			}
		}else {
		
		isSelected[cnt] = true;
		cook(cnt+1);
		isSelected[cnt] = false;
		cook(cnt+1);}
	}
}
