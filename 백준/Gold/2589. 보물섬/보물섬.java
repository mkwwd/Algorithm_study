import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int W, H, max;
	static int dx[] = {0, -1, 0, 1}, dy[] = {-1, 0, 1, 0};
	static char map[][];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new char[W][H];
		
		for(int i=0; i<W; i++) {
			String input = br.readLine();
			for(int j=0; j<H; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		max = 0;
		
		for(int i=0; i<W; i++) {
			for(int j=0; j<H; j++) {
				if(map[i][j]=='L') {
					findTreasure(i, j);
				}
			}
		}
		
		System.out.println(max);
	}

	private static void findTreasure(int x, int y) {
		
		// 방문체크
		boolean isVisited[][] = new boolean[W][H];
		isVisited[x][y] = true;
		
		Deque<int[]> dque = new ArrayDeque<>();
		dque.add(new int[] {x, y, 1});
		
		while(!dque.isEmpty()) {
			int[] start = dque.poll();
			for(int i=0; i<4; i++) {
				int nextX = start[0] + dx[i];
				int nextY = start[1] + dy[i];
				// 범위확인
				if(nextX<0 || nextX>=W || nextY<0 || nextY>=H) continue;
				// 방문한적 있다면 다음으로
				if(isVisited[nextX][nextY]) continue;
				// 땅인지 확인 아니면 다음으로
				if(map[nextX][nextY]=='W') continue;
				
				// 땅이면 큐에 추가
				dque.add(new int[] {nextX, nextY, start[2]+1});
				isVisited[nextX][nextY] = true;
				
				max = Math.max(max, start[2]);
			}
		}
		
	}

}
