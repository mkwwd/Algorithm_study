import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static int sudoku[][], stop;
	static ArrayList<int[]> zero;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sudoku = new int[9][9];
		zero = new ArrayList<>();
		
		for(int i=0; i<9; i++) {
			String input = br.readLine();
			for(int j=0; j<9; j++) {
				sudoku[i][j] = input.charAt(j)-'0';	
				if(sudoku[i][j]==0)zero.add(new int[]{i,j});
			}			
		}
		
		stop = 0;	
		play(0);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
			
	}

	private static void play(int cnt) {
		
		if(cnt == zero.size()) {
			stop = -1;
			return;
		}
		
		int x = zero.get(cnt)[0];
		int y = zero.get(cnt)[1];
		
		// 1부터 들어갈 수 있는 숫자인지 체크
		for(int i=1; i<10; i++) {
			if(check(x, y, i)) {
				sudoku[x][y] = i;
				play(cnt+1);
				// 모든 칸을 채웠으면 멈춤
				if(stop == -1) break;
				sudoku[x][y] = 0;
			}
		}
	}

	private static boolean check(int x, int y, int number) {
		
		// 가로체크
		for(int i=0; i<9; i++) {
			if(sudoku[x][i]==number) return false;
		}
		
		// 세로체크
		for(int i=0; i<9; i++) {
			if(sudoku[i][y]==number) return false;
		}
		
		// 3X3체크
		int areaX = (x/3)*3;
		int areaY = (y/3)*3;
		
		for(int i=areaX; i<areaX+3; i++) {
			for(int j=areaY; j<areaY+3; j++) {
				if(sudoku[i][j]==number) return false;
			}
		}
		// 중복되는 것이 하나도 없다면 가능한 것
		return true;
	}

}
