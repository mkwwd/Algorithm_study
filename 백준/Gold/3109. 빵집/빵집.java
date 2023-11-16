import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, cnt, stop;
	static int dx[] = {-1, 0, 1}, dy[] = {1, 1, 1};
	static char map[][];
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		cnt = 0;
		
		for(int i=0; i<R; i++) {
			visited[i][0] = true;
			stop = 0;
			dfs(i, 0);
		}
		
		System.out.println(cnt);
	
	}

	
	private static void dfs(int sx, int sy) {
		
		if(sy==C-1) {
			cnt++;
			stop = -1;
			return;
		}
		
		for(int i=0; i<3; i++) {
			if(stop == -1) break;
			int nextX = sx + dx[i];
			int nextY = sy + dy[i];
			if(nextX<0 || nextX >= R || nextY<0 || nextY >= C) continue;
			// 범위인데 건물이면 돌리기
			if(map[nextX][nextY]=='x') continue;
			// 방문체크
			if(visited[nextX][nextY]) continue;
			// 방문안했으면 방문하기
			visited[nextX][nextY] = true;
			dfs(nextX, nextY);

		}
		
	}
	
	

}
