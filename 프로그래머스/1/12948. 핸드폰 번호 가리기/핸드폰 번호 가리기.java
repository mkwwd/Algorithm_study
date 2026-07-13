class Solution {
    public String solution(String phone_number) {
        
        int len = phone_number.length();
        
        String cut = phone_number.substring(len-4);        
        
        String answer = "*".repeat(len-4);
        answer = answer + cut;
        
        return answer;
    }
}