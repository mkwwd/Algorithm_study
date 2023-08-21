import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int fruitNum = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
		int fruits[] = new int[fruitNum];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<fruitNum; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(fruits);
		
		for(int i=0; i<fruits.length; i++) {
			if(fruits[i] <= snake) {
				snake++;
			}
			else break;
		}
		
		System.out.println(snake);
	}

}
