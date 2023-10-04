import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
	static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int map[][];
	static boolean visited[][];
	static List<int[]> clouds;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 바구니 정보 배열
		map = new int[N][N];
		// 구름 있는 부분 체크할 배열
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 이동정보 저장
		int command[][] = new int[M][2];
		
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				command[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 구름 위치 저장
		clouds = new ArrayList<>();
		clouds.add(new int[] {N-1, 0});
		clouds.add(new int[] {N-1, 1});
		clouds.add(new int[] {N-2, 0});
		clouds.add(new int[] {N-2, 1});
		
		// 이동 시작 M번
		for(int i=0; i<M; i++) {
			// 방향 저장
			int dir = command[i][0]-1;
			// 거리 저장
			int dis = command[i][1]%N;
			// 구름이동
			move(dir, dis);
			// 물복사버그 마법 사용
			waterBug();
			// 바구니에 저장된 물의 양이 2이상인 모든 칸에 구름만들고, 물의 양 2 줄이기
			makeCloud();
			// 다 끝난 후에 구름 위치 초기화
			visited = new boolean[N][N];
		}
		
		//바구니에 있는 물의 양의 합
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum += map[i][j];
			}
		}
		
		System.out.println(sum);
	}


	private static void move(int dir, int dis) {
		
		 for(int[] cloud: clouds) {
			 cloud[0] = (cloud[0] + dx[dir]*dis + N)%N;
			 cloud[1] = (cloud[1] + dy[dir]*dis + N)%N;
			// 이동 후 해당 칸 물 1 증가
			 map[cloud[0]][cloud[1]]++;
			 // 이동 후 구름 위치 방문 체크
			 visited[cloud[0]][cloud[1]] = true;
		 }
	}

	private static void waterBug() {
		
		for(int[] cloud: clouds) {
			int nowX = cloud[0];
			int nowY = cloud[1];
			// 대각선에 물이 몇개있는지 체크
			int count = 0;
			for(int i=1; i<=4; i++) {
				int crossX = nowX + dx[2*i-1];
				int crossY = nowY + dy[2*i-1];
				// 범위를 벗어나면 다음 대각선 체크
				if(crossX < 0 || crossX >=N || crossY < 0 || crossY >=N) continue;
				// 범위를 벗어나지 않았다면 바구니에 물이 들어있는지 체크
				if(map[crossX][crossY] != 0) count++;
			}
			// 물 들어 있는 대각선의 수만 큼 해당 칸 물 증가
			map[nowX][nowY]+=count;			
		}		
	}
	
	private static void makeCloud() {
		
		// 새로운 구름을 생성하기 위해 list 초기화
		clouds = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 원래 구름이 있던 위치라면 체크하지 않음
				if(visited[i][j]) continue; 
				// 아니라면 물이 2이상인지 체크하고 2이상이라면 구름 생성
				if(map[i][j] >=2 ) {
					clouds.add(new int[] {i, j});
					map[i][j]-=2;
				}
			}
		}
		
	}
}
