class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        
        double stTime = h1 * 3600 + m1 * 60 + s1;
        double endTime = h2 * 3600 + m2 * 60 + s2;
        
        int answer = 0;
        
        if(stTime == 0 || stTime == 12*3600) answer ++;
        
        while(stTime < endTime){
            double h = stTime / 120 %360;
            double m = stTime / 10 % 360;
            double s = stTime * 6 % 360;
            
            double hn = (stTime+1) / 120 % 360;
            double mn = (stTime+1) / 10 % 360;
            double sn = (stTime+1) * 6 % 360;
            
            if(hn == 0) hn = 360;
            if(mn == 0) mn = 360;
            if(sn == 0) sn = 360;
            
            if(s<h && hn <= sn) answer ++;  
            if(s<m && mn <= sn) answer ++;
            if(sn == hn && hn == mn) answer --;
            
            stTime++;
        }
        
        return answer;
    }
} 