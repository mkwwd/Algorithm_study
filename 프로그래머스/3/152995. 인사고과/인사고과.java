import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        
        int a = scores[0][0];
        int b = scores[0][1];
        
        Arrays.sort(scores, new Comparator<int[]>(){
            @Override
            public int compare(int o1[], int o2[]){
                return (o2[0]+o2[1]) - (o1[0]+o1[1]);
            }
        });
        
        int cnt = 0;
        
        for(int i=0; i<scores.length; i++){
            if(scores[i][0] + scores[i][1] < a+b) break;
            boolean isPoss = true;
            for(int j=0; j<i; j++){
                if(scores[j][0] > scores[i][0] && scores[j][1] > scores[i][1]){
                    isPoss = false;
                    break;
                }
            }
            if(isPoss && scores[i][0] + scores[i][1] > a+b){
                cnt++;
            }else if(scores[i][0] == a && scores[i][1] == b){
                if(!isPoss) cnt = -1;
                else cnt++;
                break;
            }
        }
        
       
        return cnt;
    }
}