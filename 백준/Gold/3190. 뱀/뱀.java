
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	 static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int board[][] = new int[N][N];
		// 뱀 몸이 있는지 확인할 배열
		int exist[][] = new int[N][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			board[x][y] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		Deque<int[]> info = new ArrayDeque<>();
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			if(C == 'D') {
				info.add(new int[] {X, 1});
			}else {
				info.add(new int[] {X, 0});
			}	
		}
		
		int time = 0;
		Deque<Integer> directions = new ArrayDeque<>();
		directions.add(0);
		directions.add(1);
		directions.add(2);
		directions.add(3);
		
		exist[0][0] = 1;
		Deque<int []> snake = new ArrayDeque<>();
		snake.add(new int[] {0, 0});
		
		while(true) {
			
			time ++;
			// 방향가져오기
			int dir = directions.peek();
			// 머리위치가져오기
			int head[] = snake.peek();
			
			int newX = head[0] + dx[dir];
			int newY = head[1] + dy[dir];
			
			// 범위를 벗어나면 중지
			if(newX<0 || newX>=N || newY<0 || newY>=N) break;
			// 움직인 위치에 몸통이 있는지 확인, 있으면 중지
			if(exist[newX][newY] == 1) break;
			// 없으면 움직이기
			exist[newX][newY] = 1;
			
			// 새로운 머리위치 넣기, 맨 앞에
			snake.addFirst(new int[] {newX, newY});
			
			// 움직인 위치에 사과가 있는지 확인, 없으면 꼬리 제거 
			if(board[newX][newY] == 1) {
				// 있으면 사과먹기
				board[newX][newY] = 0;
			}else {
				// 없으면 꼬리때고, 꼬리위치 방문 x
				int tail[] = snake.pollLast();
				exist[tail[0]][tail[1]] = 0;
			}
			
			// 방향전환하는지 확인
			if(!info.isEmpty()&&info.peek()[0]==time) {
				if(info.peek()[1]==1) {
					int right = directions.poll();
					directions.add(right);
				}else {
					int left = directions.pollLast();
					directions.addFirst(left);
				}
				info.poll();
			}	
			
		}
		
		System.out.println(time);
	}

}
