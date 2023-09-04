import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int a[] = new int[T];
		Integer b[] = new Integer[T];
		
		for(int i=0; i<1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<T; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<T; j++) {
				b[j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		
		int sum = 0;
		for(int j=0; j<T; j++) {
			sum += a[j]*b[j];
		}
		
		System.out.println(sum);
	}

}
