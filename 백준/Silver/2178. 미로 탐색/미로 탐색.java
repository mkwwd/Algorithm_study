import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int dx[] = {1, -1, 0, 0}, dy[] = {0, 0, -1, 1}, maze[][], N, M;
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String inputs = br.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = inputs.charAt(j) - '0';
			}
		}
		
		visited = new boolean[N][M];
		visited[0][0] = true;		
		move(0, 0);	
		
		System.out.println(maze[N-1][M-1]);
	}

	private static void move(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x ,y});
		
		while(!que.isEmpty()) {
			int current[] = que.poll();
			int currentX = current[0];
			int currentY = current[1];
			
			for(int i=0; i<4; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				
				if(0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {

					if(!visited[nextX][nextY] && maze[nextX][nextY] == 1) {
						maze[nextX][nextY] = maze[currentX][currentY] + 1;
						que.add(new int[] {nextX, nextY});
						visited[nextX][nextY] = true;
					}
				}
			}
		}	
	}
}
