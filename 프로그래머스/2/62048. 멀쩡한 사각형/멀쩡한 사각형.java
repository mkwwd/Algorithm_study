class Solution {
    public long solution(int w, int h) {
        
        long size = (long)w*(long)h;
        long sum = w + h;
        long gcd = gcd(w, h);
            
        long answer = size-(sum-gcd);
        return answer;
    }
    
    public long gcd(int w, int h){
        if(w%h == 0) return h;
        else return gcd(h, w%h);
    }
    
}