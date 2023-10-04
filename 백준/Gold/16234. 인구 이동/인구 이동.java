import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	
	static int N, L, R;
	static int ground[][], dx[] = {0, -1, 0, 1}, dy[] = {-1, 0, 1, 0};
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		ground = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		while(true) {
			// 방문체크할 배열
			visited = new boolean[N][N];
			// 연합확인할 변수
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue;
					// 방문하지 않았으면 방문처리하고 연합찾기
					visited[i][j] = true;
					cnt += move(i, j);
				}
			}
			// answer이 0이면 연합이 된 것이 없는 것이므로 중단
			if(cnt == 0) break;
			// 그게 아니면 연합이 있으므로 answer++
			answer ++;
		}
		
		System.out.println(answer);
	}

	private static int move(int x, int y) {

		Deque<int[]> deque = new ArrayDeque<>();
		// 연합저장
		List<int[]> union = new ArrayList<>();
		// 현재 위치 저장
		deque.add(new int[] {x,y});
		union.add(new int[] {x,y});
		
		while(!deque.isEmpty()) {
			int now[] = deque.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				// 범위를 벗어나지 않는지 확인, 벗어나면 다음확인
				if(nextX<0 || nextX>=N || nextY<0 || nextY>=N) continue;
				// 방문한적 있는지 체크, 있으면 다음확인
				if(visited[nextX][nextY]) continue;
				// 지금좌표랑 값의 차이가 주어진 범위 사이인지 체크
				int gap = Math.abs(ground[nowX][nowY]-ground[nextX][nextY]);
				if(gap < L) continue;
				if(gap > R) continue;
				// 범위를 만족하면 연합 가능한 것이므로 방문 체크 후 deque에 넣기
				visited[nextX][nextY] = true;
				deque.add(new int[] {nextX, nextY});
				// 연합국 저장
				union.add(new int[] {nextX, nextY});
			}	
		};
		
		if(union.size()== 1){
			return 0;
		}else {
			// 연합국이 있으면 인구이동
			int avg = 0;
			for(int[] people: union) {
				avg += ground[people[0]][people[1]];
			}
			// 연합 시 인구수 계산
			avg = avg/union.size();
			// 인구 이동
			for(int[] people: union) {
				ground[people[0]][people[1]] = avg;
			}
			return 1;
		}
		
		
	}

}
