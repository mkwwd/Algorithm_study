class Solution {
    public int solution(int n) {
        int answer = findDivisor(n);
        return answer;
    }
    
    public int findDivisor(int num){
        int sum = 0;
        for(int i=1; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                sum += i;
                if(num/i != i) sum += num/i;
            }
        }
        return sum;
    }
}