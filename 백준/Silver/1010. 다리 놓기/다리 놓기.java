import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=0; test_case<T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			
			int bridge[][] = new int[N+1][M+1];
			
			for(int i=0; i<=N; i++) {
				for(int j=0, end = Math.min(i, M); j<=end; j++) {
					if(j == 0 || i == j) bridge[i][j] = 1;
					else bridge[i][j] = bridge[i-1][j-1] + bridge[i-1][j];
				}
			}
			
			System.out.println(bridge[N][M]);
			
		}

	}

}
