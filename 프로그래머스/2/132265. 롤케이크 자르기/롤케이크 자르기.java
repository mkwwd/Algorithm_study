import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        HashMap<Integer, Integer> chulsoo = new HashMap<>();
        HashMap<Integer, Integer> brother = new HashMap<>();
        
        for(int i=0; i<topping.length; i++){
            brother.put(topping[i], brother.getOrDefault(topping[i], 0)+1);
        }
        
        int answer = 0;
        
        for(int i=0; i<topping.length; i++){
            chulsoo.put(topping[i], chulsoo.getOrDefault(topping[i], 0)+1);
            if(brother.get(topping[i]) == 1){
                brother.remove(topping[i]);
            }else{
                brother.put(topping[i], brother.get(topping[i])-1);
            }
            if(chulsoo.size() == brother.size()) answer++;
        }
        
        return answer;
        
    }
}