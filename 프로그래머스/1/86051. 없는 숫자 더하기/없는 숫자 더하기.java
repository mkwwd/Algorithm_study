import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        
        boolean[] exist = new boolean[10];
        
        for(int i=0; i<numbers.length; i++){
            exist[numbers[i]] = true;
        }
        
        int answer = 0;
        
        for(int i=1; i<exist.length; i++){
            if(!exist[i]) answer += i;
        }
        
        return answer;
    }
}