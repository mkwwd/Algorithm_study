import java.util.*;

class Solution {
    
    public int solution(int[] picks, String[] minerals) {
        
        int size = picks[0]+picks[1]+picks[2];
        int min = Math.min(size*5, minerals.length);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[]o2){
                return o2[3]-o1[3];
            }
        });
        
        for(int i=0; i<min; i+=5){
            int[] tired = new int[4];
            for(int j=0; j<5; j++){
                if(i+j == min) break;
                if(minerals[i+j].equals("diamond")){
                    tired[0] += 1;
                    tired[3] += 25;
                }else if(minerals[i+j].equals("iron")){
                    tired[1] += 1;
                    tired[3] += 5;
                }else{
                    tired[2] += 1;
                    tired[3] += 1;
                }
            }
            
            pq.add(tired);
        }
        
        int answer = 0;
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(picks[0] != 0){
                answer += now[0] + now[1] + now[2];
                picks[0]--;
            }else if(picks[1] != 0){
                answer += now[0]*5 + now[1] + now[2];
                picks[1]--;
            }else{
                answer += now[0]*25 + now[1]*5 + now[2];
                picks[2]--;
            }
        }
    
           
        return answer;
    }

    
}