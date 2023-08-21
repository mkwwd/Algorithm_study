import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		String[][] arr = new String[N][M];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().split(" ");
		}
		
		int x = 0;
		int y = 0;
		int n = N;
		int m = M;
		for(int i=0; i<Math.min(N, M)/2; i++) {
			// r번회전
			for(int j=0; j<r; j++) {
				// 회전
				rotate(arr, x, y, n, m);				
			}
			x ++;
			y ++;
			n -= 2;
			m -= 2;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	public static void rotate(String[][] arr, int x, int y, int n, int m) {
		
		Queue que = new LinkedList();
		que.add(arr[x][y]);
		for(int i=1; i<n; i++) {
			x ++;
			que.add(arr[x][y]);
			arr[x][y] = (String) que.poll();
		}
		
		for(int i=1; i<m; i++) {
			y ++;
			que.add(arr[x][y]);
			arr[x][y] = (String) que.poll();
		}
		
		for(int i=1; i<n; i++) {
			x --;
			que.add(arr[x][y]);
			arr[x][y] = (String) que.poll();
		}
		
		for(int i=1; i<m; i++) {
			y --;
			que.add(arr[x][y]);
			arr[x][y] = (String) que.poll();
		}
	}
}