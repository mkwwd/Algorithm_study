import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
	static int lines[][];
	
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
                
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        
        lines = new int[V+1][V+1];
        
        for(int i=1; i<=E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            lines[from][to] = lines[to][from] = 1;
        }
        
        boolean[] visited = new boolean[lines.length];
        
        dfs(visited, start, sb);
        System.out.println(sb);
        bfs(start);
        
    }


    private static void dfs(boolean[] visited, int start, StringBuilder sb) {
        
    	sb.append(start).append(" ");
        visited[start] = true;
        
        for(int i=1; i<lines.length; i++) {
        	if(lines[start][i] == 1 && !visited[i]) {
        		visited[i] = true;
        		dfs(visited, i, sb);
        	}
        }          
    }
    
    private static void bfs(int start) {
        
        StringBuilder sb = new StringBuilder();
        int size = lines.length;
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[size];
        
        que.add(start);
        visited[start] = true;
        
        while(!que.isEmpty()) {
            int current = que.poll();
            sb.append(current).append(" ");
            
            for(int i=1; i<size; i++) {
                if(lines[current][i] == 1 && !visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
            
        }    
        
        System.out.println(sb);
        
    }

}