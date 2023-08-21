import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

public static void main(String[] args) throws NumberFormatException, IOException {
    
    int[][] board = new int[100][100];
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    
    for(int test_case = 1; test_case <= t; test_case++) {
        
    	String inputs[] = br.readLine().split(" ");
    	int xpos = Integer.parseInt(inputs[0]);
    	int ypos = Integer.parseInt(inputs[1]);
    	
    	for(int i= xpos; i<xpos+10; i++) {
    		for(int j=ypos; j<ypos+10; j++) {
    			board[i][j]++;
    		}
    	} 	  	
    }
    
    int total = 0;
    
    for(int i=0; i<100; i++) {
    	for(int j=0; j<100; j++) {
    		if(board[i][j] != 0) total++;
    	}
    }
    
    System.out.println(total);    	
  }
}