import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static char map[][];
	static boolean visited[][];
	static int sum =0, R, C, stop = 0;
	static int dx[] = {-1, 0, 1}, dy[] = {1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
				
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = line.charAt(j);			
			}
		}
		
		for(int i=0; i<R; i++) {
			visited[i][0] = true;
			stop = 0;
			setPipe(i, 0, 1);
		}
		
		System.out.println(sum);

	}

	private static void setPipe(int si, int sj, int cnt) {
		
		if(cnt == C) {
			sum ++;
			stop = -1;
			return;
		}
		
		for(int i=0; i<3; i++) {
			if(stop == -1) break;
			int nextX = si + dx[i];
			int nextY = sj + dy[i];
			
			if(nextX < 0 || nextX >= R || nextY >= C) continue;
			if(map[nextX][nextY] == '.' && !visited[nextX][nextY]) {
				visited[nextX][nextY] = true;
				setPipe(nextX, nextY, cnt+1);
			}
		}
		return;
	}
}