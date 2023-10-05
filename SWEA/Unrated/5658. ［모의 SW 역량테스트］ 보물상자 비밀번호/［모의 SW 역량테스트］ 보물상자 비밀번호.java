
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String input = br.readLine();
			
			Deque<Character> que = new ArrayDeque<>();
			PriorityQueue<Integer> pque = new PriorityQueue<>(Collections.reverseOrder());
			
			for(int i=0; i<N; i++) {
				que.add(input.charAt(i));
			}
			
			// 반복횟수, 반복
			int num = N/4;
			for(int i=0; i<num; i++) {
				// 회전, 하나 뒤로 보내기
				que.addFirst(que.pollLast());
				// 3개씩 끊어서 숫자 계산하기
				for(int j=0; j<4; j++) {
					String hex = "";
					for(int k=0; k<num; k++) {
						char a = que.poll();
						hex += a;
						que.add(a);
					}
					int num2 = Integer.parseInt(hex, 16);
					if(!pque.contains(num2)) {						
						pque.add(num2);
					}
				}
				
			}
			
			int answer = 0;
			
			for(int i=0; i<K; i++) {
				answer = pque.poll();
			}
			
			System.out.println("#"+test_case+" "+answer);
		}

	}

}
