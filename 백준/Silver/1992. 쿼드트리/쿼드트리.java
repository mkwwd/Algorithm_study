import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	static String tree[][];
	static int zero, one;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new String[N][N];
		
		for(int i=0; i<N; i++) {
			tree[i] = br.readLine().split("");
		}
		
		compress(0, 0, N);
		System.out.println(sb);
	}
	
	private static void compress(int sx, int sy, int size) {
		
		int sum = 0;
		for(int i = sx; i<sx+size; i++) {
			for(int j = sy; j<sy+size; j++) {
				sum += Integer.parseInt(tree[i][j]);
			}
		}
		
		if(sum == 0) {
			sb.append("0");
		}else if(sum == size*size) {
			sb.append("1");
		}else {
			
			sb.append('(');
			int half = size/2;
			compress(sx, sy, half);
			compress(sx, sy+half, half);
			compress(sx+half, sy, half);
			compress(sx+half, sy+half, half);	
			sb.append(')');
		}
	}
}