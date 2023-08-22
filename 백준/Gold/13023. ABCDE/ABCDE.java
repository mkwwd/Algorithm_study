import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	
	static ArrayList<Integer>[] friends;
	static boolean visited[];
	static int answer;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		friends = new ArrayList[N];
		for(int i=0; i<N; i++) {
			friends[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friends[a].add(b);
			friends[b].add(a);
		}
		
		visited = new boolean[N];
		answer = 0;
		
		for(int i=0; i<N; i++) {
			visited[i] = true;
			dfs(i,1);
			visited[i] = false;
		}

		System.out.println(answer);

	}

	private static void dfs(int start, int cnt) {
		
		if(cnt == 5) {
			answer = 1;
			return;
		}
		
		if(answer != 1){			
			for(int i=0; i<friends[start].size(); i++) {
				if(!visited[friends[start].get(i)]) {					
					visited[friends[start].get(i)] = true;
					dfs(friends[start].get(i), cnt+1);
					visited[friends[start].get(i)] = false;
				}
			}
		}
		
	}

}
