class Solution {
    public int[] solution(long n) {
        
        int len = (int)Math.log10(n) + 1;
        
        int[] answer = new int[len];
        int index = 0;
        
        while(n > 0){
            int div = (int)(n%10);
            answer[index++] = div;
            n /= 10;
        }
        
        return answer;
    }
}