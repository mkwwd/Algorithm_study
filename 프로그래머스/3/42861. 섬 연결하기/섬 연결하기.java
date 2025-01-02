import java.util.*;

class Solution {
    
    static int parent[];
    
    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int o1[], int o2[]){
                return o1[2] - o2[2];
            }
        });
        
        int answer = 0;
        parent = new int [n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        for(int i=0; i<costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                answer += costs[i][2];
                union(costs[i][0], costs[i][1]);
            }
        }
        
        return answer;
    }
    
    public int find(int now){
        if(parent[now] == now) return now;
        else return find(parent[now]);
    }
    
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
}