import java.util.*;

class Solution {
    
    static int parent[];
    
    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int o1[], int o2[]){
                return o1[2]-o2[2];
            }
        });
        
        parent = new int[n];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        
        int sum = 0;
        
        for(int i=0; i<costs.length; i++){
            if(find(costs[i][0]) == find(costs[i][1])) continue;
            sum += costs[i][2];
            union(costs[i][0], costs[i][1]);
        }
        
        return sum;
    }
    
    public void union(int a, int b){
        int pa = parent[a];
        int pb = parent[b];
        if(pa != pb) parent[pb] = pa;
    }
    
    public int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
    

}