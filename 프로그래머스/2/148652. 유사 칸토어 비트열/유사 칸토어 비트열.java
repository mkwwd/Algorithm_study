class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        for(long i=l-1; i<r; i++){
            boolean isOne = true;
            long num = i;
            while(num >=5){
                if(num % 5 == 2){
                    isOne = false;
                    break;
                }
                num /= 5;
            }
            if(num == 2) isOne = false;
            if(isOne) answer++;
        }
        return answer;
    }
}
