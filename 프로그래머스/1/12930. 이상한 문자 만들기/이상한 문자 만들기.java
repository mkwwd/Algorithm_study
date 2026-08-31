class Solution {
    public String solution(String s) {
        
        String answer = "";
        
        int idx = 0;
        
        for(int i=0; i<s.length(); i++){
            
            if(idx % 2 == 0){
                answer = answer + Character.toUpperCase(s.charAt(i));
            }else{
                answer = answer + Character.toLowerCase(s.charAt(i));
            }
            idx++;
            if(s.charAt(i) == ' ') idx = 0;
        }
            
            
        return answer;
    }
}