import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        
        int end = -50000;
        
        for(int i=0; i<routes.length; i++){
            if(end < routes[i][0]){
                end = routes[i][1];
                answer ++;
            }
        }
        
        return answer;
    }
}