import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        ArrayList<ArrayList<Integer>> roadInfo = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            roadInfo.add(new ArrayList<>());
        }
        
        for(int i=0; i<roads.length; i++){
            int from = roads[i][0];
            int to = roads[i][1];
            roadInfo.get(from).add(to);
            roadInfo.get(to).add(from);
        }
        
        int min[] = new int[n+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        min[destination] = 0;
        pq.add(new int[]{destination, 0});
        
        while(!pq.isEmpty()){
            int now[] = pq.poll();
            if(now[1] > min[now[0]]) continue;
            for(int next : roadInfo.get(now[0])){
                if(now[1]+1 <= min[next]){
                    pq.add(new int[]{next, now[1]+1});
                    min[next] = now[1]+1;
                }
            }
        }
        
        int answer[] = new int[sources.length];
        
        for(int i=0; i<answer.length; i++){
            if(min[sources[i]] == Integer.MAX_VALUE){
                answer[i] = -1;
            }else{
                answer[i] = min[sources[i]];
            }
        }
        
        return answer;
    }
}