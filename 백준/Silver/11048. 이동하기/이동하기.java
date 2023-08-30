import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static int maze[][], sum[][], dx[] = {0, -1, -1}, dy[] = {-1, -1, 0}, N, M;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		sum = new int[N][M];
				
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sum[i][j] = move(i, j);
			}
		}
		
		int answer = 0; 
		
		for(int i=0; i<M; i++) {
			answer = Math.max(answer, sum[N-1][i]);
		}
		
		System.out.println(answer);
	}

	private static int move(int x, int y) {
		
		int max = 0;
		
		for(int i=0; i<3; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(newX < 0 || newX >= N || newY < 0 || newY >= M) continue;
			max = Math.max(max, sum[newX][newY]);
		}
		
		return maze[x][y] + max;
	}

}
