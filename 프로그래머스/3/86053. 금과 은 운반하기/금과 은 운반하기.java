import java.util.*;

class Solution {
    
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        
        long start = 0;
        long end = (long) (10e9 * 2 * 10e5 * 2);
        long answer = 0;
        
        while(start <= end){
            long mid = (start+end)/2;
            long totalSum = 0;
            long goldSum = 0;
            long silverSum =0;
            
            for(int i=0; i<t.length; i++){
                long cnt = mid/(2*t[i]);
                if(mid%(2*t[i]) >= t[i]) cnt++;
                
                long weight = cnt*w[i];
                goldSum += Math.min(g[i], weight);
                silverSum += Math.min(s[i], weight);
                totalSum += Math.min(g[i] + s[i], weight);               
            }
            
            if(a <= goldSum && b <= silverSum && a+b <= totalSum){
                end = mid-1;
                answer = mid;
            }else{
                start = mid+1;
            }                             
        }
        
        return answer;
    }
}