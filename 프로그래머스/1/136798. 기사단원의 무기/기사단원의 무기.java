import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        
        int answer = 0;
        
        for(int i=1; i<=number; i++){
            int cnt = div(i);
            if(cnt <= limit){
                answer += cnt;
            }else{
                answer += power;
            }
        }
        
        return answer;
    }
    
    public int div(int num){
        
        if(num == 1) return 1;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=1; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                set.add(i);
                set.add(num/i);
            }
        }
        
        return set.size();
        
    }
}