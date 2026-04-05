import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        ArrayList<ArrayList<Integer>> node = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            node.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            node.get(from).add(to);
            node.get(to).add(from);
        }

        boolean visited[] = new boolean[n+1];
        visited[1] = true;
        
        Deque<Integer> que = new ArrayDeque<>();
        que.add(1);
        
        int size = 0;
        
        while(!que.isEmpty()){
            size = que.size();
            for(int i=0; i<size; i++){
                int now = que.poll();
                for(int next : node.get(now)){
                    if(visited[next]) continue;
                    visited[next] = true;
                    que.add(next);
                }
            }
        }
        
        return size;
    }
}