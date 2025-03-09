import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        HashMap<Integer, Integer> tang = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
           tang.put(tangerine[i], tang.getOrDefault(tangerine[i],0)+1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[1] - o1[1]; 
            }
        });
        
        tang.forEach((key, value) -> {
            pq.add(new int[] {key, value});
        });
        
        int answer = 0;
        int cnt = 0;
        
        while(cnt < k){
            int now[] = pq.poll();
            cnt += now[1];
            answer++;
        }

        return answer;
    }
}