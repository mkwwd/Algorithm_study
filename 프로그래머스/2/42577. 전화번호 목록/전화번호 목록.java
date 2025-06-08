import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        boolean answer = true;
        
        for(int i=1; i<phone_book.length; i++){
            String pre = phone_book[i-1];
            String number = phone_book[i];
            if(pre.length() <= number.length() && number.substring(0, pre.length()).equals(pre)){
                answer = false;
                break;
            }
        }
        
        
        return answer;
    }
}