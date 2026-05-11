import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        boolean answer = true;
        
        for(int i=1; i<phone_book.length; i++){
            String pre = phone_book[i-1];
            String now = phone_book[i];
            if(now.length() >= pre.length() && now.substring(0, pre.length()).equals(pre)){
                answer = false;
            }
        }
        
        return answer;
    }
}