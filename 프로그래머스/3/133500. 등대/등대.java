import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> light = new ArrayList<>();
    static int answer = 0;
    
    public int solution(int n, int[][] lighthouse) {
   
        for(int i=0; i<=n; i++){
            light.add(new ArrayList<>());
        }
        
        for(int i=0; i<lighthouse.length; i++){
            int from = lighthouse[i][0];
            int to = lighthouse[i][1];
            light.get(from).add(to);
            light.get(to).add(from);
        }
        
        dfs(1, 0);
        
        return answer;
    }
    
    public int dfs(int cur, int past){
        
        if(light.get(cur).size() == 1 && light.get(cur).get(0) == past) return 1;
        
        int cnt = 0;
        for(int next : light.get(cur)){
            if(next == past) continue;
            cnt += dfs(next, cur);
        }
        
        if(cnt == 0) return 1;
        answer++;
        return 0;
    }
}