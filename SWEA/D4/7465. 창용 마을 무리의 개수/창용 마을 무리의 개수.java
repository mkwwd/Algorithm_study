import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int person[][];
	static boolean check[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());

		for(int i=1; i<=test_case; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			person = new int[N+1][N+1];
			check = new boolean[N+1];
			
			for(int j=0; j<M; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				person[start][end] = 1;
				person[end][start] = 1;
			}
			
			int cnt = 0;
			for(int j=1; j<N+1; j++) {
				if(check[j]) continue;
				check[j] = true;
				cnt++;
				bfs(j);
			}
			
			System.out.printf("#%d %d \n",i, cnt);
			
		}
		
		
	}

	private static void bfs(int start) {
		
		Deque<Integer> que = new ArrayDeque<>();
		que.add(start);
		while(!que.isEmpty()) {
			int now = que.poll();
			// 지금 위치와 친구인 사람들 넣기
			for(int i=1; i<N+1; i++) {
				// 관계가 없거나 다른 무리 사람이면 건너뜀
				if(check[i] || person[now][i] == 0) continue;
				// 관계있으면 que에 넣기
				check[i] = true;
				que.add(i);
			}
		}
	}

}
