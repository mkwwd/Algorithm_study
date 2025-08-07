class Solution {
    public int[] solution(String s) {
        
        int cnt = 0;
        int del = 0;
        
        while(s.length() > 1){
            int len = s.length();
            s = s.replace("0", "");
            int len2 = s.length();
            del += len - len2;
            s = Integer.toBinaryString(len2);
            cnt++;
        }

        int[] answer = {cnt, del};
        return answer;
    }
}