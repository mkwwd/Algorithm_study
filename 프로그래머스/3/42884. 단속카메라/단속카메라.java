import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int o1[], int o2[]){
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        
        int cnt = 1;
        int cctv = routes[0][1];
        
        for(int i=0; i<routes.length; i++){
            if(routes[i][0]<=cctv && cctv <= routes[i][1]) continue;
            cnt++;
            cctv = routes[i][1];
        }
            
        return cnt;
    }
}