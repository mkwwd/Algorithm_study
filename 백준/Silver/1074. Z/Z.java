import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static int r, c, sum, stop;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		double size = Math.pow(2, N);
		
		find(0, 0, (int)size);
		
		System.out.println(sum);

	}

	private static void find(int si, int sj, int size) {
		
		if(size == 1) return;
		
		int half = size/2;
		
		if(r<si+half && c<sj+half) {
			find(si, sj, half);
		}
		else if(r<si+half && sj+half <= c){
			sum += half*half;
			find(si, sj+half, half);
		}
		else if(si+half<=r && c<sj+half){
			sum += half*half*2;
			find(si+half, sj, half);
		}
		else{
			sum += half*half*3;
			find(si+half, sj+half, half);
		}
		
	}
}