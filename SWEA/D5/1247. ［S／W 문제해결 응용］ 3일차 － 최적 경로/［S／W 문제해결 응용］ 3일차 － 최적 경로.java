import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int min, client, clientHome[][], path[];
	static boolean isSelected[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			min = 3000;
			client = Integer.parseInt(br.readLine());
			
			// 회사, 집, 고객 정보를 담을 배열 생성 -> 고객수 + 2 크기의 배열
			clientHome = new int[client+2][2];
			st = new StringTokenizer(br.readLine());
			
			// 배열에 좌표 집어넣기
			for(int i=0; i<client+2; i++) {
				for(int j=0; j<2; j++) {
					clientHome[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 고객 배달 순서를 정할 배열 생성
			path = new int[client + 2];
			// 배열 첫번째 값에는 clientHome의 첫번째가 회사이므로 0 넣어줌
			path[0] = 0;
			// 배열 마지막 값에는 clientHome의 두 번째가 도착지인 집이므로 1 넣어줌
			path[client+1] = 1;
			// 배달 시작, 2번 인덱스부터 마지막인덱스까지 조합
			isSelected = new boolean[client+2];
			// 첫번째 path에는 이미 0이 있기 때문에 1부터시작
			deliveryStart(1);
			
			System.out.println("#"+test_case+" "+min);
		}

	}
	
	private static void deliveryStart(int cnt) {
		
		if(cnt == client+1) {
			// 끝나면 거리계산해보기
			sumPath(path);
			return;
		}
		
		// 2부터 고객수+2가 배열 크기 이므로 마지막 인덱스 번호까지 
		for(int i=2; i<client+2; i++) {
			if(isSelected[i]) continue;
			path[cnt] = i;
			isSelected[i] = true;
			deliveryStart(cnt+1);
			isSelected[i] = false;
		}
		
	}

	private static void sumPath(int[] path) {
		
		int sum = 0;
		// 
		for(int i=0; i<client+1; i++) {
			sum += Math.abs(clientHome[path[i]][0] - clientHome[path[i+1]][0]) + Math.abs(clientHome[path[i]][1] - clientHome[path[i+1]][1]);
			if(sum > min) break;
		}
		
		min = Math.min(min, sum);
	}
}