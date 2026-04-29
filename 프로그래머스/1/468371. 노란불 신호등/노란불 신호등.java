class Solution {
    public int solution(int[][] signals) {
        
        int lcm = 1;
        int N = signals.length;
        int signLen[] = new int[N];
        
        for(int i=0; i<N; i++){
            int len = 0;
            for(int j=0; j<3; j++){
                len += signals[i][j];
            }
            signLen[i] = len;
            lcm *= len/gcd(lcm, len);
        }
        
        int answer = -1;
        
        for(int i=1; i<lcm; i++){
            int cnt = 0;
            for(int j=0; j<N; j++){
                int mod = i%signLen[j];
                if(mod == 0) mod = signLen[j];
                if(signals[j][0] < mod && mod <= signLen[j] - signals[j][2]){
                    cnt++;
                }
            }
            if(cnt == N){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public int gcd(int a, int b){
        if(a%b  == 0) return b;
        else return gcd(b, a%b);
    }
    
}