import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
    
        HashMap<Integer, Integer> tangCnt = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            tangCnt.put(tangerine[i], tangCnt.getOrDefault(tangerine[i], 0)+1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int o1[], int o2[]){
                return o2[1] - o1[1];
            }
        });
        
        tangCnt.forEach((key, value) -> {
            pq.add(new int[] {key, value});
        });
        
        int cnt = 0;
        int answer = 0;
        
        while(cnt < k){
            int now[] = pq.poll();
            cnt += now[1];
            answer ++;
        }

        return answer;
    }
}