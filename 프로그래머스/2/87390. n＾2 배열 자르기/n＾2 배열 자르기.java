import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int range = (int)(right-left);
        int answer[] = new int[range+1];
        long cnt = 0;
        int index = 0;
        
        for(int i=1; i<=n; i++){
            if((long)i*n-1 < left){
                cnt += n;
                continue;
            }
            for(int j=1; j<=n; j++){
                if(cnt < left) {
                    cnt++;
                    continue;
                }
                if(left <= cnt && cnt <= right){
                    cnt++;
                    answer[index++] = Math.max(i, j);
                    continue;
                }
                break;
            }
            if(cnt > right) break;
        } 
        
        return answer;
    }
}