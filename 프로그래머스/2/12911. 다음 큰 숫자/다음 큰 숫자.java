class Solution {
    public int solution(int n) {
        
        String bin = Integer.toBinaryString(n);
        bin = bin.replace("0","");
        int len = bin.length();
        int answer = 0;
        
        while(true){
            n++;
            String next = Integer.toBinaryString(n);
            next = next.replace("0","");
            int nextLen = next.length();
            if(len == nextLen) {
                answer = n;
                break;
            }           
        }
        
        return answer;
    }
}