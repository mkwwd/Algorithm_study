class Solution {
    public String solution(int n) {
        
        String rule[] = {"4", "1", "2"};
        String answer = "";
        
        while(n > 0){
            
            int div = n%3;
            answer = rule[div] + answer;
            n /= 3;
            if(div == 0) n--;
        }
        
        
        return answer;                                                                
    }
}