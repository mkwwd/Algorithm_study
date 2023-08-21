import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Queue que = new LinkedList();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=n; i++) {
			que.add(i);
		}
		
		int result[] = new int[n];
		int index = 0;
		
		while(!que.isEmpty()) {
			for(int j=0; j<k-1; j++) {				
				que.add(que.poll());
			}
			result[index++] = (int) que.poll();
		}

		
		StringBuilder sb = new StringBuilder();
        int count = 0;
        
        sb.append("<");
        for(int re : result) {
            count ++;
            if(count == result.length) {
            	sb.append(re);
            }else {            	
            	sb.append(re+", ");
            }
        }
        sb.append(">");
        
        System.out.println(sb.toString());
		
	}
}