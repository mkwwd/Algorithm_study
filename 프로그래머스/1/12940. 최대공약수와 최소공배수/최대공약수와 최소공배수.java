class Solution {
    public int[] solution(int n, int m) {
        
        int answer[] = new int[2];
        
        int gcbNum = gcb(n, m);
        int lcmNum = n*m/gcbNum;
        
        answer[0] = gcbNum;
        answer[1] = lcmNum;
        
        return answer;
    }
    
    public int gcb(int a, int b){
        if(a % b == 0) return b;
        else return gcb(b, a%b);
    }
}