import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int R,C;
	// 위쪽 공기청정기
	static int dx[] = {0, -1, 0, 1}, dy[]= {1, 0, -1, 0};
	// 아래쪽 공기청정기
	static int room[][], copy[][];
	static List<int[]> puris;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C]; 
		puris = new ArrayList<>();
		
		for(int i=0; i<R; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j]==-1) {
					puris.add(new int[] {i, j});
				}
			}
		}
		
		int time = 0;
		
		while(time<T) {
			
			time++;
			
			copy = new int[R][C];
			// 미세먼지 확산하기
			for(int i=0; i<R; i++){
				for(int j=0; j<C; j++) {
					if(room[i][j]!=0) {
						spread(i, j);
					}
				}
			}
			
			// 공기청정기 돌리기
			air(0);
			air(1);
			
			for(int i=0; i<R; i++){
				for(int j=0; j<C; j++) {
					room[i][j] = copy[i][j];
				}
			}
			
		}
		
		int sum = 0;

		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++) {
				if(room[i][j]==-1) continue;
				sum += room[i][j];
			}
		}
		
		System.out.println(sum);
		
	}

	// 공기 청정기 돌리기
	private static void air(int k) {
		
		// 위쪽돌리기
		Deque<Integer> que = new ArrayDeque<>();
		que.add(0);
		int puri[] = puris.get(k);
		// 우선 오른쪽으로 이동
		int nowX = puri[0] + dx[0];
		int nowY = puri[1] + dy[0];
		while(true) {
			que.add(copy[nowX][nowY]);
			copy[nowX][nowY] = que.poll();
			int nextX = nowX + dx[0];
			int nextY = nowY + dy[0];
			if(nextX<0 || nextX>=R || nextY<0 || nextY>=C) break;
			nowX = nextX;
			nowY = nextY;
		}
		
		if(k==0) {
			for(int i=1; i<4; i++) {
				while(true) {
					int nextX = nowX + dx[i];
					int nextY = nowY + dy[i];
					if(nextX<0 || nextX>=R || nextY<0 || nextY>=C) break;
					if(nextX==puri[0]&&nextY==puri[1]) break;
					que.add(copy[nextX][nextY]);
					copy[nextX][nextY] = que.poll();
					nowX = nextX;
					nowY = nextY;
				}
			}
		}else {
			for(int i=3; i>0; i--) {
				while(true) {
					int nextX = nowX + dx[i];
					int nextY = nowY + dy[i];
					if(nextX<0 || nextX>=R || nextY<0 || nextY>=C) break;
					if(nextX==puri[0]&&nextY==puri[1]) break;
					que.add(copy[nextX][nextY]);
					copy[nextX][nextY] = que.poll();
					nowX = nextX;
					nowY = nextY;
				}
			}
		}
	}

	private static void spread(int x, int y) {
		
		int amount = room[x][y]/5;
		int cnt = 0;
		for(int i=0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			// 범위안에 있는지 체크
			if(nextX<0 || nextX>=R || nextY<0 || nextY>=C) continue;
			// 공기청정기이면 패스
			if(room[nextX][nextY]==-1) continue;
			// 범위안에 있으면 확산가능한 위치 이므로
			cnt++;
			copy[nextX][nextY] += amount;
		}
		// 확산 후에 원래 위치에 남은 값 계산
		copy[x][y] += room[x][y] - cnt*amount;
	}

}
