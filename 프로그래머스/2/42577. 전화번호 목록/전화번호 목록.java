import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        boolean answer = true;
        
        for(int i=0; i<phone_book.length-1; i++){
            String num = phone_book[i];
            int size1 = num.length();
            String title = phone_book[i+1];
            if(title.length() >= num.length() && title.substring(0, size1).equals(num)){
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}