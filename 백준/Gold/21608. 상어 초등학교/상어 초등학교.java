import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int dx[] = {0, -1, 0, 1}, dy[] = {-1, 0, 1, 0};
	static int seat[][], students[][], favor[][], blank[][];
	static int N, max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		seat = new int[N][N];
		int total = N*N;
		students = new int[total+1][4];
		int sum = 0;
		
		for(int i=0; i<total; i++) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			for(int j=0; j<4; j++) {
				students[student][j] = Integer.parseInt(st.nextToken());
			}
			// 좋아하는 학생이 인접한 칸에 가장 많은 칸의 수 반환
			max = 0;
			int maxFavor = findFavor(student);
			// 가장 많은 칸의 수인 자리 가져오기
			List<int[]> answer = findMax(maxFavor, favor);
			// 가장 많은 칸이 하나이면 자리 주고 다음 친구 배정하기}
			
			if(answer.size()==1) {
				seat[answer.get(0)[0]][answer.get(0)[1]] = student;
				continue;
			}
			
			
			// 아니라면 비어있는 칸이 가장 많은 자리 찾기
			max = 0;
			int maxBlank = findBlank(answer);
			answer = findMax(maxBlank, blank);
			// 비어있는 칸이 가장 많은 칸이 하나이면 자리 지정, 아니면 가장 앞에 있는 것 지정
			// 둘다 같음, 가장 앞에 있는 칸으로 자리 지정
			seat[answer.get(0)[0]][answer.get(0)[1]] = student;
		}
		
		// 만족도 계산
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int student = seat[i][j];
				sum += score(i, j, student);
			}
		}
		
		System.out.println(sum);
	
	}
	
	private static double score(int nowX, int nowY, int student) {
		
		int favor = 0;
		for(int i=0; i<4; i++) {
			int newX = nowX+dx[i];
			int newY = nowY+dy[i];
			if(newX < 0 || newX >= N || newY < 0 || newY >= N) continue;
			// 벗어나지 않았다면 확인
			for(int j=0; j<4; j++) {
				if(seat[newX][newY] == students[student][j]) favor++;
			}
		}
		
		double score = Math.pow(10, favor)/10;
		
		return score;

	}

	private static List<int[]> findMax(int maxFavor, int arr[][]) {
		
		List<int[]> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(seat[i][j]!=0) continue;
				if(arr[i][j]==maxFavor) {
					list.add(new int[] {i,j});
				}
			}
		}
		
		return list;
	}

	private static int findBlank(List<int[]> answer) {
		
		blank = new int[N][N];
		
		for(int[] list : answer) {
			// 현재 위치
			int nowX = list[0];
			int nowY = list[1];
			int cnt = 1;
			// 주변 빈칸 탐색
			for(int k=0; k<4; k++) {
				int newX = nowX+dx[k];
				int newY = nowY+dy[k];
				if(newX < 0 || newX >= N || newY < 0 || newY >= N) continue;
				// 벗어나지 않았다면 확인
				if(seat[newX][newY] == 0) {
					cnt++;
				}
			}
			
			blank[nowX][nowY] = cnt;
			max = Math.max(max, cnt);
		}
		
		return max;
	}


	private static int findFavor(int student) {
		
		favor = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 비어 있는 자리만 확인
				if(seat[i][j] != 0) continue;
				// 비어 있지 않다면 인접한 부분 탐색
				int cnt = 0;
				for(int k=0; k<4; k++) {
					int newX = i+dx[k];
					int newY = j+dy[k];
					if(newX < 0 || newX >= N || newY < 0 || newY >= N) continue;
					// 벗어나지 않았다면 확인
					for(int m=0; m<4; m++) {
						if(seat[newX][newY] == students[student][m]) cnt++;
					}
				}
				// 인접한 좋아하는 친구수 저장
				favor[i][j] = cnt;
				// 좋아하는 친구수 최대값 저장하기
				max = Math.max(cnt, max);
		   }
		}
		return max;
	}

}
