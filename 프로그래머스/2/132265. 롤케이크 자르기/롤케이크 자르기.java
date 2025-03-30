import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        HashMap<Integer, Integer> a = new HashMap<>();
        HashMap<Integer, Integer> b = new HashMap<>();
        
        for(int i=0; i<topping.length; i++){
            b.put(topping[i], b.getOrDefault(topping[i], 0)+1);
        }
        
        int answer = 0;
        
        for(int i=0; i<topping.length-1; i++){
            int now =topping[i];
            a.put(now, a.getOrDefault(now, 0)+1);
            if(b.getOrDefault(now, 0) == 1){
                b.remove(now);
            }else{
                b.put(now, b.getOrDefault(now, 0)-1);
            }
            
            if(a.size() == b.size()) answer++;
        } 
        
        return answer;
    }
}