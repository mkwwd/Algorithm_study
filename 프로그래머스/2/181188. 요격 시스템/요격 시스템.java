import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });  
        
        int answer = 0;
        int pos = 0;
        
        for(int i=0; i<targets.length; i++){
            if(targets[i][0] >= pos){
                answer ++;
                pos = targets[i][1];
            }
        }
        
        return answer;
    }
}