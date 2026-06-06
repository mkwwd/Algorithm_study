class Solution {
    public long solution(int price, int money, int count) {
        
        long answer = 0;
        
        while(count > 0){
            answer += count*price;
            count--;
        }
        
        if(money >= answer) return 0;

        return answer-money;
    }
}