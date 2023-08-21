import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=1; i<=t; i++) {
			que.add(i);
		}
		
		while(que.size() >1) {
			que.poll();
			int up = que.poll();
			que.add(up);			
		}
		
		System.out.println(que.peek());
	}
}
