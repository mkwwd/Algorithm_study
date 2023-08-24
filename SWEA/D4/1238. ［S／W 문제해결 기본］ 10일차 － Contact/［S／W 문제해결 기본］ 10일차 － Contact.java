import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static ArrayList<Integer>[] students;
	static ArrayDeque<int[]> que;
	static int number[];
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case=1; test_case<=10; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			students = new ArrayList[101];
			number = new int[101];
			visited = new boolean[101];
			
			for(int i=0; i<101; i++) {
				students[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
					
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				students[from].add(to);
			}  
			
			visited[start] = true;
			
			que = new ArrayDeque<>();
			que.add(new int[] {start, 1});
			
			bfs();
			
			int max = 0;
			for(int i=0; i<101; i++) {
				max = Math.max(max, number[i]);
			}
			
			int last = 0;
			for(int i=0; i<101; i++) {
				if(number[i] == max) last = i;
			}
			
			System.out.println("#"+test_case+" "+last);
		}
	}

	private static void bfs() {
		
		while(!que.isEmpty()) {
			int arr[] = que.poll();
			
			for(int i : students[arr[0]]) {
				if(visited[i]) continue;
				visited[i] = true;
				number[i] = arr[1];
				que.add(new int[] {i, arr[1]+1});
			}
			
		}
		
	}

}