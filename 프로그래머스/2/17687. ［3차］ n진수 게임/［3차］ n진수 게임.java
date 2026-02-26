class Solution {
    public String solution(int n, int t, int m, int p) {
        
        int len = t*m;
        String str = "";
        int num = 0;
        
        while(str.length() < len){
            String convert = Integer.toString(num, n);
            str += convert;
            num++;
        }
        
        str = str.toUpperCase();
        String answer = "";
        int tube = p-1;
        
        for(int i=0; i<t; i++){
            answer += str.charAt(tube);
            tube += m;
        }
        
        
        return answer;
    }
}