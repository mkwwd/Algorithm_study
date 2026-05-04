class Solution {
    public int solution(int[] wallet, int[] bill) {
        
        int maxW = Math.max(wallet[0], wallet[1]);
        int minW = Math.min(wallet[0], wallet[1]);
        
        int maxB = Math.max(bill[0], bill[1]);
        int minB = Math.min(bill[0], bill[1]);
        
        int answer = 0;
        
        while(maxW < maxB || minW < minB){
            answer ++;
            maxB /= 2;
            if(maxB < minB){
                int a = minB;
                minB = maxB;
                maxB = a;
            }
        }

        return answer;
    }
}