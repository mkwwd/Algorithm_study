import java.util.*;

class Solution {
    
    static int tired[][] = {{1, 1, 1},{5, 1, 1},{25, 5, 1}};
    
    public int solution(int[] picks, String[] minerals) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o2[0] != o1[0]) return o2[0] - o1[0];
                if(o2[1] != o1[1]) return o2[1] - o1[1];
                return o2[2] - o1[2];
            }
        });
        
        int size = Math.min((int)Math.ceil((double)minerals.length/5), (picks[0] + picks[1] + picks[2]));
            
        for(int i=0; i<minerals.length;){
            if(pq.size() == size) break;
            int[] count = new int[3];
            for(int j=0; j<5; j++){
                if(i+j >= minerals.length) break;
                if(minerals[i+j].equals("diamond")){
                    count[0]++;
                }else if(minerals[i+j].equals("iron")){
                    count[1]++;
                }else{
                    count[2]++;
                }
            }
            pq.add(count);
            i += 5;
        };
        
        int answer = 0;
        
        while(!pq.isEmpty()){
            
            if(picks[0] > 0){
                answer += breakMinerals(0, pq.poll());
                picks[0]--;
            }else if(picks[1] > 0){
                answer += breakMinerals(1, pq.poll());
                picks[1]--;
            }else if(picks[2] > 0){
                answer += breakMinerals(2, pq.poll());
                picks[2]--;
            }else break;
        }
           
        return answer;
    }
    
    public int breakMinerals(int pick, int[] minerals){
        
        int cnt = 0;
        
        for(int i=0; i<minerals.length; i++){
            cnt += tired[pick][i] * minerals[i];
        } 
        
        return cnt;
    }
    
}