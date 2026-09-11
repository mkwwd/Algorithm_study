class Solution {
    public String solution(int n) {
        
        String word[] = {"4", "1", "2"};
        String answer = "";
        
        while(n > 0){
            int mod = n%3;
            answer = word[mod]+answer;
            n /= 3;
            if(mod==0) n--;
        }
        
        return answer;                                                                
    }
}