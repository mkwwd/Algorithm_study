class Solution {
    public long[] solution(int x, int n) {
        
        long[] answer = new long[n];
        
        for(int i=0; i<n; i++){
            long num = (long)x*(i+1);
            answer[i] = num;
        }
        
        return answer;
    }
}