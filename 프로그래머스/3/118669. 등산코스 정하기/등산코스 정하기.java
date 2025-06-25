import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<int[]>> info; 
    static HashSet<Integer> summ, ga;
    static int[] intensity;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        info = new ArrayList<>();
        
        for(int i=0; i<n+1; i++){
            info.add(new ArrayList<>());
        }
        
        for(int i=0; i<paths.length; i++){
            int from = paths[i][0];
            int to = paths[i][1];
            int value = paths[i][2];
            info.get(from).add(new int[]{to, value});
            info.get(to).add(new int[]{from, value});
        }
        
        summ = new HashSet<>();
        ga = new HashSet<>();
        
        for(int i=0; i<summits.length; i++){
            summ.add(summits[i]);
        }
        
        for(int i=0; i<gates.length; i++){
            ga.add(gates[i]);
        }      
       
        int su = 0;
        int min = Integer.MAX_VALUE;
        
        intensity = new int[n+1];
        find(gates);
        
        for(int j=1; j<intensity.length; j++){
            if(summ.contains(j) && intensity[j] < min){
                su = j;
                min = intensity[j];
            }
        }
                       
        
        int[] answer = {su, min};
       
        
        return answer;
    }
    
    public void find(int[] start){
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);              
        Arrays.fill(intensity, Integer.MAX_VALUE);     
        
        for(int i=0; i<start.length; i++){
            pq.add(new int[] {start[i], 0});
            intensity[start[i]] = 0;
        }    
        
        while(!pq.isEmpty()){
            int now[] = pq.poll();
            // 현재위치가 봉우리이면 패스
            if(summ.contains(now[0])) continue;
            if(intensity[now[0]] < now[1]) continue;
            
            for(int[] next : info.get(now[0])){
                
                // 게이트이면 패스
                if(ga.contains(next[0])) continue;
                // intensity
                int inten = Math.max(now[1], next[1]);
                
                if(inten < intensity[next[0]]) {
                    intensity[next[0]] = inten;
                    pq.add(new int[]{next[0], inten});
                }
                
            }
        }
        
    }
    
}