class Solution {
    public String solution(String s) {
        
        int num = s.length()/2;
        
        String answer = "";
        
        if(s.length()%2 == 0){
            answer = s.substring(num-1, num+1);
        }else{
            answer = s.substring(num, num+1);
        }
        
        return answer;
    }
}