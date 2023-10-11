import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static char field[][], currentDir;
	static int H, W, currentX, currentY;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			currentX = 0;
			currentY = 0;
			
			field = new char[H][W];
			
			for(int i=0; i<H; i++) {
				String elements = br.readLine(); 
				for(int j=0; j<W; j++) {					
					char element = elements.charAt(j); 
					field[i][j] = element;
					if(field[i][j] == '^' || field[i][j] == 'v' || field[i][j] == '<' || field[i][j] == '>') {
						currentX = i;
						currentY = j;
						currentDir = field[i][j];
					}
				}			
			}
			
			int count = Integer.parseInt(br.readLine());
			String inputs = br.readLine(); ;
			for(int i=0; i<count; i++) {
				char input = inputs.charAt(i);
				switch(input) {
				
				case 'S':
					shoot();
					break;
				case 'U':
					move(-1, 0, '^');
					break;
				case 'D':
					move(1, 0, 'v');
					break;
				case 'L':
					move(0, -1, '<');
					break;
				case 'R':
					move(0, 1, '>');
					break;
				  
				}
			}
			
			sb.append("#").append(test_case).append(" ");
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					sb.append(field[i][j]);
				}
				sb.append("\n");
			}
			
			System.out.print(sb);
		}

	}

	private static void move(int i, int j, char changeDir) {
		
		currentDir = changeDir;
		field[currentX][currentY] = changeDir;
		int changeX = currentX+i;
		int changeY = currentY+j;
		
		if(0 <= changeX && changeX < H && 0 <= changeY && changeY < W && field[changeX][changeY] == '.') {
			field[currentX][currentY] = '.';
			currentX = changeX;
			currentY = changeY;
			field[changeX][changeY] = currentDir;
		}
		
	}


	private static void shoot() {
		
		switch(currentDir) {
		
		case '^':
			for(int i=currentX; i>0; i--) {
				if(field[i-1][currentY] == '*') {
					field[i-1][currentY] = '.';
					break;
				}
				if(field[i-1][currentY] == '#') break;
			}
			break;
		case 'v':
			for(int i=currentX; i<H-1; i++) {
				if(field[i+1][currentY] == '*') {
					field[i+1][currentY] = '.';
					break;
				}
				if(field[i+1][currentY] == '#') break;
			}
			break;
		case '<':
			for(int i=currentY; i>0; i--) {
				if(field[currentX][i-1] == '*') {
					field[currentX][i-1] = '.';
					break;
				}
				if(field[currentX][i-1] == '#') break;
			}
			break;
		case '>':
			for(int i=currentY; i<W-1; i++) {
				if(field[currentX][i+1] == '*') {
					field[currentX][i+1] = '.';
					break;
				}
				if(field[currentX][i+1] == '#') break;
			}
			break;
		}
		
	}

}