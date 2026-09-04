class Solution {
    public String solution(String s, int n) {
        
        String answer = "";
        
        for(int i=0; i<s.length(); i++){
            char alpha = s.charAt(i);
            int ascii = (int)alpha;
            if(ascii >= 65 && ascii <= 90){
                ascii -= 65;
                ascii = (ascii + n)%26;
                ascii += 65;
            }else if(ascii >= 97 && ascii <=122){
                ascii -= 97;
                ascii = (ascii + n)%26;
                ascii += 97;
            }else{
                answer = answer + " ";
                continue;
            }
            answer = answer + (char)ascii;
        }
        
        return answer;
    }
}