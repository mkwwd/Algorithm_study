import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	
	static int T, max, sum, time, schedule[][], list[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		schedule = new int[T][2];
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				schedule[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		start(0, 0);
		
		System.out.println(max);

	}

	private static void start(int st, int sum) {
		
		if(st >= T) { // 상담중단
			max = Math.max(max, sum);
			return;
		}
		
		if(st + schedule[st][0]<=T) { // 상담이 더 가능하면 다음 상담 진행
			start(st + schedule[st][0], sum + schedule[st][1]);
		}else { // 상담을 더 할 수 없음
			start(st + schedule[st][0], sum);
		}
		
		
		// 다음날로
		start(st+1, sum);
	}
		

}
