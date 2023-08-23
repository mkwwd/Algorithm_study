import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 1부터 사용하므로 하나 더 크게 생성
		ArrayList<Integer>[] students = new ArrayList[N+1];
		// 차수 저장할 배열
		int count[] = new int[N+1]; 
		
		for(int i=1; i<=N; i++) {
			students[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			students[front].add(next);
			count[next]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(count[i] == 0) que.add(i);
		}
		
		while(!que.isEmpty()) {
			int x = que.poll();
			
			sb.append(x).append(" ");
			
			for(int student : students[x]) {
				count[student] --;
				if(count[student] == 0) que.add(student);
			}
			
		}
		
		System.out.println(sb);
	}

}