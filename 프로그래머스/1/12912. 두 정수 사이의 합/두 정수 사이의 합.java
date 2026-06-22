class Solution {
    public long solution(int a, int b) {
        
        if(a == b) return a;
        
        int from = Math.min(a, b);
        int to = Math.max(a, b);
        
        long answer = 0;
        
        for(int i=from; i<=to; i++){
            answer += i;
        }
        
        return answer;
    }
}