import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

	static List<ArrayList> list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		list = new ArrayList<>();

		for(int i=0; i<4; i++) {
			String input = br.readLine();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int j=0; j<8; j++) {
				arr.add(input.charAt(j)-'0');
			}
			list.add(arr);
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int wheel = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			rotate(wheel, dir);
		}
		
		int score = 0;
		// 12시방향 가져오기
		for(int i=0; i<4; i++) {
			int top = (int)list.get(i).get(0);
			if(top!= 0) {				
				score += Math.pow(2, i);
			}
		}
		
		System.out.println(score);
	}

	private static void rotate(int wheel, int dir) {
		
		// 회전할 친구 넣기
		Deque<int[]> que = new ArrayDeque<>();
		que.add(new int[] {wheel, dir});
		
		// 지금 위치에서 왼쪽 부분 체크
		int newDir = dir;
		for(int i=wheel; i>0; i--) {
			newDir = newDir *-1;
			ArrayList<Integer> now = list.get(i);
			ArrayList<Integer> pre = list.get(i-1);		
			if(now.get(6)!=pre.get(2)) {
				que.add(new int[] {i-1, newDir});
			}else break;
		}
		
		// 지금 위치에서 오른쪽 부분 체크
		int newDir2 = dir;
		for(int i=wheel; i<3; i++) {
			newDir2 = newDir2 *-1;
			ArrayList<Integer> now = list.get(i);
			ArrayList<Integer> next = list.get(i+1);	
			if(now.get(2)!=next.get(6)) {
				que.add(new int[] {i+1, newDir2});
			}else break;
		}
		
		int size = que.size();
		for(int i=0; i<size; i++) {
			int ro[] = que.poll();
			// 오른쪽으로 회전
			if(ro[1]==1) {
				int move = (int)list.get(ro[0]).remove(7);
				list.get(ro[0]).add(0, move);
			}else { // 왼쪽으로 회전
				int move = (int)list.get(ro[0]).remove(0);
				list.get(ro[0]).add(move);
			}
		}
	}
	

}
