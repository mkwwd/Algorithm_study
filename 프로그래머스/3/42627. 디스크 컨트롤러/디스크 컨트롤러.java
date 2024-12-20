import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int o1[], int o2[]){
                return o1[0]-o2[0];
            }
        });
        
        for(int i=0; i<jobs.length; i++){
            pq.add(new int[] {jobs[i][0], jobs[i][1]});
        }
        
        int time = 0;
        int answer = 0;
        
        PriorityQueue<int[]> wait = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int o1[], int o2[]){
                return o1[1] - o2[1];
            }
        });
            
        while(!pq.isEmpty() || !wait.isEmpty()){
            while(!pq.isEmpty()){
                int info[] = pq.peek();
                if(info[0] <= time){
                    wait.add(info);
                    pq.poll();
                }else break;
            }
            
            if(wait.isEmpty()){
                time++;
            }else{
               int work[] =  wait.poll();
                time += work[1];
                answer += time - work[0];
            }
            
        }
       
        return answer/jobs.length;
    }
}