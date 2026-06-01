class Solution {
    public int solution(int n) {
        
        int left = 1;
        int right = 2;
        int sum = left+right;
        int answer = 0;
        
        if(n <= 2) return 1;
        
        while(left <= right){
            if(sum <= n){
                if(sum == n) answer++;
                right++;
                sum += right;
            }else{
                sum -= left;
                left++;
            }
        }
       
        return answer;
    }
}