import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] check = new int[4];
	static String[] count = new String[4];
	static int answer;
	
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs;
        
        inputs = br.readLine().split(" ");
        
        int length = Integer.parseInt(inputs[0]);
        int pass = Integer.parseInt(inputs[1]);
        
        inputs = br.readLine().split("");
        count = br.readLine().split(" ");
        
        for(int i=0; i<pass; i++) {
        	plus(inputs[i]);
        }
        
        isPossible();
        
        for(int i=0; i<length-pass; i++) {            
        	minus(inputs[i]);
        	plus(inputs[i+pass]);
        	isPossible();
        }               
        System.out.println(answer);
    }
    
    public static void plus(String a) {

        if(a.equals("A")) {check[0]++;}
        if(a.equals("C")) {check[1]++;}
        if(a.equals("G")) {check[2]++;}
        if(a.equals("T")) {check[3]++;}  
    }
    
    public static void minus(String a) {
        
    	if(a.equals("A")) {check[0]--;}
        if(a.equals("C")) {check[1]--;}
        if(a.equals("G")) {check[2]--;}
        if(a.equals("T")) {check[3]--;}
    }
    
    public static void isPossible(){
    	int same = 0;
    	for(int j=0; j<4; j++) {
            if(check[j] >= Integer.parseInt(count[j])) {
            	same++;
            }
        }
    	if(same == 4) {    		
    		answer ++;
    	}
    }   
}