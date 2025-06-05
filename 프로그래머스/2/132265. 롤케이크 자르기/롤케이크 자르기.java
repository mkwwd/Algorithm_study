import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        HashMap<Integer, Integer> a = new HashMap<>();
        HashMap<Integer, Integer> b = new HashMap<>();
        
        for(int i=0; i<topping.length; i++){
            b.put(topping[i], b.getOrDefault(topping[i], 0) + 1);
        }
        
        int cnt = 0;
        
        for(int i=0; i<topping.length; i++){
            a.put(topping[i], a.getOrDefault(topping[i], 0) + 1);
            int out = b.getOrDefault(topping[i], 0);
            if(out == 1){
                b.remove(topping[i]);
            }else{
                b.put(topping[i], out-1);
            }
            
            if(a.size() == b.size()) cnt++;
        }
        
        return cnt;
        
    }
}