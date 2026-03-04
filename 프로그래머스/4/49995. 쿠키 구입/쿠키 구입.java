import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        
        int answer = 0;
        
        for(int i=0; i<cookie.length-1; i++){
            int left = i;
            int leftSum = cookie[left];
            int right = i+1;
            int rightSum = cookie[right];
            while(true){
                if(leftSum == rightSum && leftSum > answer){
                    answer = leftSum;
                }else if(leftSum > rightSum && right < cookie.length -1){
                    right++;
                    rightSum += cookie[right];
                }else if(rightSum >= leftSum && left > 0){
                    left--;
                    leftSum += cookie[left];
                }else break;
            }
        }

        return answer;
    }
}