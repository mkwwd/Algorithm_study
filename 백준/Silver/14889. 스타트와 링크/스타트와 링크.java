import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int min = Integer.MAX_VALUE;
	static int com[][];
	static boolean list[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		com = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				com[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list = new boolean[N];
		
		makeStart(0, 0);
		
		System.out.println(min);

	}

	private static void makeStart(int st, int cnt) {
		
		if(cnt==N/2) {
			// 능력치 비교하기
			int start = 0;
			int link = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(list[i]&&list[j]) {
						start += com[i][j];
					}
					else if(!list[i]&& !list[j]) {
						link += com[i][j];
					}
				}
			}
			// 가장 작은 값 갱신
			min = Math.min(min, Math.abs(start-link));
			
			return;
		}
		// 팀 조합하기
		for(int i=st; i<N; i++) {
			list[i] = true;
			makeStart(i+1, cnt+1);
			list[i] = false;
		}
		
	}


}
