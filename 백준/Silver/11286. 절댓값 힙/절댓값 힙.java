import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				if(Math.abs(a) == Math.abs(b)) {
					return a - b;
				} else {
					return Math.abs(a) - Math.abs(b);
				}
			}
		});

		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(que.isEmpty()) {
					sb.append("0"+"\n");
				}
				else {
					sb.append(que.poll()+"\n");
				}
			}
			else {
				que.add(input);
			}
		}
		
		System.out.println(sb.toString());
		
	}

}