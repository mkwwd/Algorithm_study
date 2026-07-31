class Solution {
    boolean solution(String s) {
        
        String nop = s.replace("p", "").replace("P", "");
        String noy = s.replace("y", "").replace("Y", "");
        
        boolean answer = true;

        if(nop.length() != noy.length()) answer = false;

        return answer;
    }
}