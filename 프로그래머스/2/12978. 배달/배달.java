import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {

        ArrayList<ArrayList<int[]>> village = new ArrayList<>();
        
        for(int i=0; i<N+1; i++){
            village.add(new ArrayList<>());
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        
        int time[] = new int[N+1];
        for(int i=0; i<time.length; i++){
            time[i] = Integer.MAX_VALUE;
        }
        
        time[1] = 0;
        
        for(int i=0; i<road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int value = road[i][2];
            village.get(from).add(new int[]{to, value});
            village.get(to).add(new int[]{from, value});
            if(from == 1){
                pq.add(new int[]{to, value});
                time[to] = Math.min(time[to], value);
            }else if(to == 1){
                pq.add(new int[]{from, value});
                time[from] = Math.min(time[from], value);
            }
        }
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            for(int[] next : village.get(now[0])){
                // 현재까지의 거리와 다음거리의 합산이 더 작은가
                if(now[1] + next[1]<=time[next[0]]){
                    time[next[0]] = now[1] + next[1];
                    pq.add(new int[] {next[0], now[1] + next[1]});
                }
            }
        }
        
        int answer = 0;
        
        for(int i=1; i<time.length; i++){
            if(time[i] <= K){
                answer++;
            }
        }

        return answer;
    }
}