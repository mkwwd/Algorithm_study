import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	static char area[][];
	static boolean visited[][];
	static int N, dx[] = {0, -1, 0, 1}, dy[] = {-1, 0, 1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		area = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {				
				area[i][j] = input.charAt(j);
			}
		}
		
		int rgb1 = 0;

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) continue;
				RGB1(i, j);
				rgb1 ++;
			}
		}
		
		sb.append(rgb1).append(" ");

		int rgb2 = 0;
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) continue;
				if(area[i][j] == 'B') {					
					RGB1(i, j);
				}else {
					RGB2(i, j);
				}
				rgb2 ++;
			}
		}
		
		sb.append(rgb2);
		System.out.println(sb);
	
	}


	private static void RGB2(int si, int sj) {
		
		for(int i=0; i<4; i++) {
			int nextX = si + dx[i];
			int nextY = sj + dy[i];
			
			if(nextX<0 || nextX>=N || nextY<0 || nextY>=N) continue;
			
			if(area[nextX][nextY] != 'B'&& !visited[nextX][nextY]) {
				visited[nextX][nextY] = true;
				RGB2(nextX, nextY);
			}	
		}
		
	}


	private static void RGB1(int si, int sj) {
		
		for(int i=0; i<4; i++) {
			int nextX = si + dx[i];
			int nextY = sj + dy[i];
			
			if(nextX<0 || nextX>=N || nextY<0 || nextY>=N) continue;
			
			if(area[nextX][nextY] == area[si][sj] && !visited[nextX][nextY]) {
				visited[nextX][nextY] = true;
				RGB1(nextX, nextY);
			}	
		}		
	}
	
}