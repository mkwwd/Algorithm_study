import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                start = true;
                sb.append(" ");
            }else{
                if(start){
                    sb.append(Character.toUpperCase(s.charAt(i)));
                    start = false;
                }else{
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
            }
        }
        
        return sb.toString();
        
    }
}