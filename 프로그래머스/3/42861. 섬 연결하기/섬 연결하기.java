import java.util.*;

class Solution {
    
    static int parent[];
    
    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        
        parent = new int[n+1];
        
        for(int i=1; i<n+1; i++){
            parent[i] = i;
        }
        
        int answer = 0;
        
        for(int i=0; i<costs.length; i++){
            int from = costs[i][0];
            int to = costs[i][1];
            if(find(from) == find(to)) continue;
            answer += costs[i][2];
            union(from, to);
        }
        
        return answer;
    }
    
    public int find(int node){
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }
    
    public void union(int a, int b){
        int pa = parent[a];
        int pb = parent[b];
        if(pa != pb) parent[pb] = pa;
    }

}