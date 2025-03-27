import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        ArrayList<ArrayList<Integer>> info = new ArrayList<>();
        
        for(int i=0; i<n+1; i++){
            info.add(new ArrayList<>());
        }
        
        for(int i=0; i<roads.length; i++){
            int from = roads[i][0];
            int to = roads[i][1];
            info.get(from).add(to);
            info.get(to).add(from);
        }
        
        int[] answer = new int[sources.length];
        int[] min = new int[n+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        min[destination] = 0;
        pq.add(new int[] {destination, 0});
             
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(min[now[0]] < now[1]) continue;
                
            for(int next : info.get(now[0])){
                if(min[next] > now[1] + 1){
                    min[next] = now[1] + 1;
                    pq.add(new int[] {next, now[1]+1});
                }
            }
        }
        
        for(int i=0; i<sources.length; i++){
            if(min[sources[i]] == Integer.MAX_VALUE){
                answer[i] = -1;
            }else{
                answer[i] = min[sources[i]];
            }
        }
        
        return answer;
    }
}