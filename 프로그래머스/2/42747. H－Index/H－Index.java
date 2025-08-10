import java.util.*;

class Solution {
    public int solution(int[] citations) {
       
        Arrays.sort(citations);
        
        int max = citations[citations.length-1];
        int cnt = 0;
        
        for(int i=citations.length-1; ;){
            if(cnt >= max) break;
            if(i >=0 && max <= citations[i]){
                cnt++;
                i--;
                continue;
            }
            max--;
        }
        
        return max;
    }
}