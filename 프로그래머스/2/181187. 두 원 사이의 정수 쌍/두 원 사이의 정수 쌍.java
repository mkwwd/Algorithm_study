import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        
        long answer = 0;
        
        for(int i=1; i<r2; i++){
            // x좌표기준 반지름이 s2가 되는 점의 좌표개수
            int max = (int)Math.sqrt(Math.pow(r2,2)-Math.pow(i,2));
            int min = (int)Math.ceil(Math.sqrt(Math.pow(r1,2)-Math.pow(i,2)));
            answer += max-min+1;
        }
        
        answer *= 4;
        answer += 4;
        
        return answer;
    }
}