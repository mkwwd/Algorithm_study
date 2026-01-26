class Solution {
    public long[] solution(long[] numbers) {
        
        long[] answer = new long [numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]%2 == 0){
                answer[i] = numbers[i] + 1;
                continue;
            }else{
                answer[i] = numbers[i] + (Long.lowestOneBit(~numbers[i]) >> 1);
            }
        }
        
        return answer;
    }
}