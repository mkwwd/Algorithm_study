import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack stack = new Stack<Integer>();
		
		
		int T = Integer.parseInt(br.readLine());
		int list[][] = new int[T][2];
		int totalScore = 0;
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			// 업무 여부, 점수, 시간 받기
			int work = Integer.parseInt(st.nextToken());
			
			// 업무가 주어지면 리스트에 점수와 시간 저장
			if(work == 1) {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				list[i][0] = score;
				list[i][1] = time;
				// stack에 업무 넣어주기
				stack.add(i);
			}
			// 업무가 있다면 시작
			if(!stack.isEmpty()) {
				// 가장 위에 있는 것 가져오기
				int start = (int) stack.pop();
				// 해당 인덱스의 시간 1분 줄이기
				list[start][1] --;
				// 시간이 0이 아니라면 업무가 남았기 때문에 다시 stack에 추가
				if(list[start][1] != 0) {
					stack.add(start);			
				}else {
					// 시간이 0이 되었다면 업무가 끝난 것이므로 점수 획득!!!!
					totalScore += list[start][0];
				}
				
			}
			
		}
		
		System.out.println(totalScore);
	}

}