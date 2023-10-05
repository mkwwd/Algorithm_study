
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
	
	static int N, min;
	static int cave[][], arr[][];
	static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cnt = 0;
		
		while(true) {
			
			cnt ++;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0) break;
			cave = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[N][N];			
			visited[0][0] = true;
			min=Integer.MAX_VALUE;
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				Arrays.fill(arr[i], Integer.MAX_VALUE);				
			}
			
			arr[0][0] = cave[0][0];
			bfs(0,0);
			
			System.out.println("Problem "+cnt+": "+arr[N-1][N-1]);
			
		}

	}

	private static void bfs(int x, int y) {
		
		Deque<int[]> que = new ArrayDeque<>();
		que.add(new int[] {x, y});
		
		while(!que.isEmpty()) {
			int now[] = que.poll();
			for(int i=0; i<4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				// 범위 체크
				if(nextX<0 || nextX>=N || nextY<0 || nextY>=N) continue;
				int sum = cave[nextX][nextY] + arr[now[0]][now[1]];
				if(arr[nextX][nextY] > sum) {
					arr[nextX][nextY] = sum;					
					que.add(new int[] {nextX, nextY});
				}
			}
		}
		
	}

}
