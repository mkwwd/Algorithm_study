class Solution {
    public int solution(int a, int b, int n) {
        
        int answer = 0;
        
        while(a <= n){
            int trade = n/a*b;
            int left = n%a;
            answer += trade;
            n = trade + left;
        }
        
        
        return answer;
    }
}