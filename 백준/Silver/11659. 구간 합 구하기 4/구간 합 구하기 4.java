import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	 public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        String[] inputs;
	        
	        inputs = br.readLine().split(" ");
	    
	        int N = Integer.parseInt(inputs[0]);
	        int M = Integer.parseInt(inputs[1]);
	        
	        inputs = br.readLine().split(" ");
	        int[] sum = new int[N];
	        sum[0] = Integer.parseInt(inputs[0]);
	        
	        
	        for(int i=1; i<N; i++) {    
	            sum[i] = sum[i-1] + Integer.parseInt(inputs[i]);
	        }
	        
	        for(int j=0; j<M; j++) {
	        	inputs = br.readLine().split(" ");
	        	int st = Integer.parseInt(inputs[0])-1;
	        	int end = Integer.parseInt(inputs[1])-1;
	        	int ans = 0;
	        	if(st == 0) { ans = sum[end];}
	        	else {
	        		ans = sum[end] - sum[st-1];
	        	}
	        	System.out.println(ans);
	        }
	    }
}