import java.util.*;

class Solution {
    
    static HashMap<String, Integer> list = new HashMap<>();
    static HashMap<String, Integer> sale = new HashMap<>();
    static int answer = 0;
    
    public int solution(String[] want, int[] number, String[] discount) {
        
        for(int i=0; i<want.length; i++){
            list.put(want[i], number[i]);
        }
         
        for(int i=0; i<10; i++){
            sale.put(discount[i], sale.getOrDefault(discount[i], 0) + 1);
        }
        
        checkStock(want);
            
        for(int i=0; i<discount.length - 10; i++){
            sale.put(discount[i], sale.getOrDefault(discount[i], 0) -1);
            sale.put(discount[i+10], sale.getOrDefault(discount[i+10], 0) + 1);
            checkStock(want);
        }
        
        return answer;
    }
    
    public void checkStock(String[] want){
        
        int cnt = 0;
        
        for(int i=0; i<want.length; i++){
            if(list.get(want[i]) <= sale.getOrDefault(want[i], 0)) cnt++;
        }
        
        if(cnt == want.length) answer++;
        
    }
}