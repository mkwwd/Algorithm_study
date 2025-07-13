import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int[] parent = new int[enroll.length+1];
        int[] money = new int[enroll.length];
        
        HashMap<String, Integer> number = new HashMap<>();
        
        for(int i=0; i<enroll.length; i++){
            number.put(enroll[i], i+1);
        }
        
        for(int i=0; i<referral.length; i++){
            if(referral[i].equals("-")) continue;
            parent[i+1] = number.get(referral[i]);
        }
        
        for(int i=0; i<seller.length; i++){
            int num = number.get(seller[i]);
            int price = amount[i] * 100;
            while(num != 0){
                int give = price / 10;
                money[num-1] += price - give;
                num = parent[num];
                price = give;
            }
        }
        
    
        return money;
    }
}