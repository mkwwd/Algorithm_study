class Solution {
    public long solution(int w, int h) {
        
        long total = (long)w*(long)h;
        long cut = w+h;
        long dupl = gcp(w, h);
            
        long answer = total-(cut-dupl);
        return answer;
    }
    
    public long gcp(int w, int h){
        if(h==0) return w;
        return gcp(h, w%h);
    }
}