import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        
        int answer = 0;
        int min = 1;
        int max = 10000*n;
        int cnt = 0;
        
        while(min <= max){
            int mid = (min+max)/2;
            cnt = cores.length;
            for(int i=0; i<cores.length; i++){
                cnt += mid/cores[i];
            }
            
            if(cnt >= n){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        
        cnt = cores.length;
        
        for(int i=0; i<cores.length; i++){
            cnt += (min-1)/cores[i];
        }
        
        for(int i=0; i<cores.length; i++){
            if(min % cores[i] == 0){
                cnt++;
                if(cnt == n){
                    answer = i+1;
                    break;
                }
            }
        }
        
        return answer;
    }
}