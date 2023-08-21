import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		
		int result[] = new int[t];
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> num = new Stack<>();
		stack.add(Integer.parseInt(input[t-1]));
		num.add(t-1);
	
		for(int i=t-2; i>=0; i--) {
			while(!stack.isEmpty()) {				
				if(stack.peek() < Integer.parseInt(input[i])) {
					stack.pop();
					int index = num.pop();
					result[index] = i+1; }
				else break;
			}
			stack.add(Integer.parseInt(input[i]));
			num.add(i);
		}
		
        StringBuilder sb = new StringBuilder();
		
		for(int r : result) {
			sb.append(r+" ");
		}
		
		System.out.println(sb.toString());
		
	}	
}