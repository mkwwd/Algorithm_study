import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int answer[] = new int[2];
        
        for(int i=1; i<=(int)Math.sqrt(yellow); i++){       
            if(yellow%i != 0) continue;
            int width = yellow/i + 2;
            int height = i+2;
            int brownCnt = width*height - yellow;
            if(brownCnt == brown){
                answer[0] = width;
                answer[1] = height;
                break;
            } 
        }
     
        return answer;
    }
}
