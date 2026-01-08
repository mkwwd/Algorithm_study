import java.util.*;

class Solution {
    
    static int answer = 0;
    static HashMap<String, Integer> list = new HashMap<>();
    static HashMap<String, Integer> sale = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        
        for(int i=0; i<want.length; i++){
            list.put(want[i], number[i]);
        }
    
        for(int i=0; i<10; i++){
            sale.put(discount[i], sale.getOrDefault(discount[i], 0) + 1);
        }
        
        checkWant(want);
        
        for(int i=10; i<discount.length; i++){
            sale.put(discount[i-10], sale.get(discount[i-10]) -1);
            sale.put(discount[i], sale.getOrDefault(discount[i], 0) + 1);
            checkWant(want);
        }
        
        
        return answer;
    }
    
    public void checkWant(String[] want){
        
        int cnt = 0;
        
        for(int i=0; i<want.length; i++){
            if(list.get(want[i]) <= sale.getOrDefault(want[i], 0)) cnt++;
        }
        
        if(cnt == list.size()) answer++;
        
    }

}