import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int time = 0;
        int answer = 0;
        int index = 0;
        int finish = 0;
        
        while(finish < jobs.length){
            while(index < jobs.length && time >= jobs[index][0]){
                pq.add(jobs[index++]);
            }
            
            if(pq.isEmpty()){
                time = jobs[index][0];
            }else{
                int out[] = pq.poll();
                time += out[1];
                answer += time - out[0];
                finish++;
            }
        }
        
       
        return answer/jobs.length;
    }
}