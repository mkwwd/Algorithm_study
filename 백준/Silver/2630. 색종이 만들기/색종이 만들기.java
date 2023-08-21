import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int paper[][];
	static int white, blue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		findPaper(0, 0, N);
		System.out.println(white);
		System.out.println(blue);

	}
	
	private static void findPaper(int sx, int sy, int size) {
		
		int sum = 0;
		for(int i = sx; i<sx+size; i++) {
			for(int j = sy; j<sy+size; j++) {
				sum += paper[i][j];
			}
		}
		
		if(sum == 0) {
			white++;
		}else if(sum == size*size) {
			blue++;
		}else {
			int half = size/2;
			findPaper(sx, sy, half);
			findPaper(sx, sy+half, half);
			findPaper(sx+half, sy, half);
			findPaper(sx+half, sy+half, half);	
		}
	}
}