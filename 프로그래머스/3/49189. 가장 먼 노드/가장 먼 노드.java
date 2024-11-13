import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        int dept[] = new int[n+1];
        ArrayList<ArrayList<Integer>> info = new ArrayList<>();
        
        for(int i=0; i<n+1; i++){
            info.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            info.get(from).add(to);
            info.get(to).add(from);
        }
        
        Deque<Integer> node = new ArrayDeque<>();
        boolean visited[] = new boolean[n+1];
        
        node.add(1);
        visited[1] = true;
        int size = 0;
        
        while(!node.isEmpty()){
            size = node.size();
            for(int i=0; i<size; i++){
                int now = node.poll();
                for(int a : info.get(now)){
                    if(visited[a]) continue;
                    visited[a] = true;
                    node.add(a);
                }
            }
        }
        
        return size;
    }
}