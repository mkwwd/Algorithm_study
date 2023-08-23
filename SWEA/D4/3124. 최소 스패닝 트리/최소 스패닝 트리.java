import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Edge implements Comparable<Edge>{
		int to;
		int weigth;
		
		Edge(int to, int weigth){
			this.to = to;
			this.weigth = weigth;	
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weigth - o.weigth;
		}
		
	}

	static ArrayList<Edge>[] graph;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[V + 1];
			
			for(int i=0; i<graph.length; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weigth = Integer.parseInt(st.nextToken());
				
				graph[from].add(new Edge(to, weigth));	
				graph[to].add(new Edge(from, weigth));
			}
			
			long answer = prim(V);
			System.out.println("#"+test_case+" "+answer);
		}

	}

	private static long prim(int v) {
		boolean[] visit = new boolean[v+1];
		
		PriorityQueue<Edge> pque = new PriorityQueue<>();
		pque.offer(new Edge(1, 0));
		
		long total = 0;
		while(!pque.isEmpty()) {
			Edge edge = pque.poll();
			if(visit[edge.to]) continue;
			visit[edge.to] = true;

			int to = edge.to;
			int weight = edge.weigth;
			
			total += weight;
			
			for(Edge e: graph[to]) {
				if(!visit[e.to]) {
					pque.add(e);
				}
			}
		}
		return total;
	}
}