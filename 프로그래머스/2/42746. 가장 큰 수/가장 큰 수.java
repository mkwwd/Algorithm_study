import java.util.*; 

class Solution {
    
    public String solution(int[] numbers) {
        
        String num[] = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            num[i] = numbers[i]+"";
        }
        
        Arrays.sort(num, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        String answer = "";
        
        if (num[0].equals("0")) {
            return "0";
        }
        
        for(int i=0; i<num.length; i++){
            answer = answer + num[i];
        }
        
        return answer;
    }
    
}