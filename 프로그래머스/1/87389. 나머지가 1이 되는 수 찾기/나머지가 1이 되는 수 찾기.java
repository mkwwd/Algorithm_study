class Solution {
    public int solution(int n) {
        
        int answer = findNum(n-1);
        
        return answer;
    }
    
    public int findNum(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0) return i;
        }
        return num;
    }
}