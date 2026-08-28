class Solution {
    public int solution(String t, String p) {
        
        int len = p.length();
        int answer = 0;
        
        for(int i=0; i<t.length()-len+1; i++){
            if(t.charAt(i)-'0' > p.charAt(0)-'0') continue;
            String str = t.substring(i, i+len);
            long num = Long.parseLong(str);
            long psize = Long.parseLong(p);
            if(num <= psize) answer++;
        }
        
        return answer;
    }
}