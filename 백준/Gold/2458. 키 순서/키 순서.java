import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int students[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 학생 수
		N = Integer.parseInt(st.nextToken());
		// 키 비교 횟수
		int M = Integer.parseInt(st.nextToken());
		
		students = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			students[start][end] = 1;
		}
		
		int answer = 0;
		
		// 키 몇번째인지 구하기
		for(int i=1; i<=N; i++) {
			int bigS = big(i);
			int smallS = small(i);
			if(bigS + smallS == N-1) answer++;
		}
		
		System.out.println(answer);
		
	}


	private static int big(int student) {
		
		Deque<Integer> que = new ArrayDeque<>();
		boolean check[] = new boolean[N+1];
		int cnt = 0;
		
		for(int i=1; i<=N; i++) {
			if(students[student][i]==1) {
				que.add(i);
				check[i] = true;
				cnt++;
			}
		}
		
		while(!que.isEmpty()) {
			student = que.poll();
			for(int i=1; i<=N; i++) {
				if(students[student][i]==1) {
					if(check[i]) continue;
					que.add(i);
					check[i] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}

	private static int small(int student) {
		
		Deque<Integer> que = new ArrayDeque<>();
		boolean check[] = new boolean[N+1];
		int cnt = 0;
		
		for(int i=1; i<=N; i++) {
			if(students[i][student]==1) {
				que.add(i);
				check[i] = true;
				cnt++;
			}
		}
		
		while(!que.isEmpty()) {
			student = que.poll();
			for(int i=1; i<=N; i++) {
				if(students[i][student]==1) {
					if(check[i]) continue;
					que.add(i);
					check[i] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
		
	}
	
}
