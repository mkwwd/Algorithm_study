import java.io.*;

class Solution {
    public int solution(int n) {
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            int mod = n%3;
            sb.insert(0, Integer.toString(mod));
            n /= 3;
        }
        
        String reverse = sb.reverse().toString();

        int answer = Integer.parseInt(reverse, 3);
        
        return answer;
    }
}