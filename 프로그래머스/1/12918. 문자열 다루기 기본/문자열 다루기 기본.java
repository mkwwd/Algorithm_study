class Solution {
    public boolean solution(String s) {
        
        if(s.length() != 4 && s.length() != 6) return false;
        
        int number = 0;
        boolean answer = true;
        
        try{
            number = Integer.parseInt(s);
        }catch(NumberFormatException e){
            answer = false;
        }
        
        return answer;
        
    }
}