import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int map[][], route[], N, min;
	static boolean isSelected[];
 	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		route = new int[N+1];
		isSelected = new boolean[N];
		min = 4000000;
		
		makeRoute(0);
		
		System.out.println(min);

	}

	private static void makeRoute(int cnt) {
		
		if(cnt == N) {
			route[N] = route[0];
			findMin(route);
		}
		
		for(int i=0; i<N; i++) {			
			if(isSelected[i]) continue;
			route[cnt] = i;
			isSelected[i] = true;
			makeRoute(cnt+1);
			isSelected[i] = false;
		}
		
	}

	private static void findMin(int[] route) {
		
		int sum = 0;
		
		for(int i=0; i<route.length-1; i++) {
			if(map[route[i]][route[i+1]] == 0) return;
			sum += map[route[i]][route[i+1]];
			if(sum > min) break;
		}
		
		min = Math.min(min, sum);
	}

}
