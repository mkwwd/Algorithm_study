import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        
        for(int i=1; i<=(int) Math.sqrt(yellow); i++){
            if(yellow%i == 0){
                int sum = (yellow/i + i + 2) * 2;
                if(sum == brown){
                    answer[0] = yellow/i + 2;
                    answer[1] = i + 2;
                    break;
                }
            }
        }
     
        return answer;
    }
}
