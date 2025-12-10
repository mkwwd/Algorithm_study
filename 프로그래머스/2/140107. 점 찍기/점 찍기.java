class Solution {
    public long solution(int k, int d) {
    
        long answer = 0;
        
        for(int i=0; i<=d; i++){
            if(i != 0 && i % k != 0) continue;
            int max = (int)Math.sqrt(Math.pow(d,2) - Math.pow(i,2));
            answer += max/k;
        }
        
        answer += d/k + 1;
        
        return answer;
    }
}