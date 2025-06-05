import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        
        int a = scores[0][0];
        int b = scores[0][1];
        int sum = a+b;
        
        Arrays.sort(scores, new Comparator<int[]>(){
            @Override
            public int compare(int o1[], int o2[]){
                return (o2[0] + o2[1]) -  (o1[0] + o1[1]);
            }
        }); 
        
        int cnt = 0;
        
        for(int i=0; i<scores.length; i++){
            // 
            boolean possible = true;
            for(int j=i-1; j>=0; j--){
                if(scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]){
                    possible = false;
                    break;
                }
            }
            
            if(possible && scores[i][0] + scores[i][1] > sum) {
                System.out.println(i);
                cnt++;
            }
            
            if(scores[i][0] == a && scores[i][1] == b) {
                if(possible) cnt++;
                else cnt = -1;
                break;
            };
            
        }
        
        return cnt;
    }
}