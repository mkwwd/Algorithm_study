import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	static int[][] room;
	static int count, N, max, minIndex, indexX, indexY;
	static ArrayList<Integer> counts;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String[] input = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					room[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			max = 0;
			minIndex = N*N;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					indexX = i;
					indexY = j;
					move(i, j, 1);

				}
			}
			
			System.out.println("#"+test_case+" "+minIndex+" "+max);
		}
		
	}

	private static void move(int i, int j, int value) {
		
		if(max==value && value!=1) {
			minIndex = Math.min(minIndex, room[indexX][indexY]);
		}
		else if(value > max) {
			minIndex = room[indexX][indexY] ;
			max = value;
		}
		
				
		// 위
		if(i > 0) {
			if(room[i-1][j] - room[i][j] ==1) {
				move(i-1, j, value+1);
			}
		}
		
		// 왼
		if(j > 0) {
			if(room[i][j-1] - room[i][j] ==1) {
				move(i, j-1, value+1);
			}
		}
		
		// 아래
		if(i < N-1) {
			if(room[i+1][j] - room[i][j] ==1) {
				move(i+1, j, value+1);
			}
		}
		
		// 오른쪽
		if(j < N-1) {
			if(room[i][j+1] - room[i][j] ==1) {
				move(i, j+1, value+1);
			}
		}
		
	}
}