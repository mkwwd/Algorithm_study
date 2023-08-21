import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static boolean visited[][], usedAlpha[];
	static char board[][];
	static int dx[] = {1, -1, 0, 0}, dy[] = {0, 0, -1, 1}, R, C, max;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String inputs = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j] = inputs.charAt(j);
			}
		}
		
		visited = new boolean[R][C];
		usedAlpha = new boolean[26];
		
		max = 0;
		
		visited[0][0] = true;
		usedAlpha[(int)board[0][0]-65] = true;
		move(1, 0, 0);
		
		System.out.println(max);

	}

	private static void move(int count, int x, int y) {
		
		max = Math.max(count, max);
		for(int i=0; i<4; i++) {
			
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(0 <= nextX && nextX < R && 0 <= nextY && nextY < C) {
				int alpha = (int)board[nextX][nextY]-65;
				if(!visited[nextX][nextY] && !usedAlpha[alpha]) {
					visited[nextX][nextY] = true;
					usedAlpha[alpha] = true;
					move(count+1 , nextX, nextY);
					visited[nextX][nextY] = false;
					usedAlpha[alpha] = false;
				}
			}
			
		}		
		
	}

}