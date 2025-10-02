import java.util.*;

class Solution {
    public int solution(int[] arr) {
        
        Deque<Integer> que = new ArrayDeque<>();
        
        for(int i=0; i<arr.length; i++){
            que.add(arr[i]);
        }
        
        Arrays.sort(arr);
        
        int i=2;
        int max = arr[arr.length-1];
        int answer = 1;
        
        while(i<=max){
            int cnt = 0;
            int len = que.size();
            for(int j=0; j<len; j++){
                int now = que.poll();
                if(now%i == 0){
                    cnt++;
                    now /= i;
                }
                if(now != 1) que.add(now);
            }
            
            if(cnt == 0) i++;
            else answer *= i;
        }
        
        return answer;
    }
}