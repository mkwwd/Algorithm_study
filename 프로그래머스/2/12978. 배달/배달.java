import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        
        ArrayList<ArrayList<int[]>> roadInfo = new ArrayList<>();
        int minTime[] = new int[N+1];
        
        for(int i=0; i<=N; i++){
            roadInfo.add(new ArrayList<>());
            minTime[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0; i<road.length; i++){
            
            int from = road[i][0];
            int to = road[i][1];
            int time = road[i][2];
            
            roadInfo.get(from).add(new int[]{to, time});
            roadInfo.get(to).add(new int[]{from, time});
            
        }
        
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{1,0});
        minTime[1] = 0;
        
        while(!que.isEmpty()){
            int now[] = que.poll();
            if(minTime[now[0]] < now[1]) continue;
            for(int next[]: roadInfo.get(now[0])){
                int sum = now[1]+next[1];
                if(minTime[next[0]] >= sum){
                    minTime[next[0]] = sum;
                    que.add(new int[]{next[0], sum});
                }
            }
        }
        
        int answer = 0;
        
        for(int i=1; i<=N; i++){
            if(minTime[i] <= K) answer++;
        }

        return answer;
    }
}