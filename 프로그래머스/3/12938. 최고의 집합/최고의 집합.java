class Solution {
    public int[] solution(int n, int s) {
        
        int div = s/n;
        int left = s%n;
        
        if(div == 0) return new int[] {-1};
        
        int answer[] = new int[n];
        
        for(int i=n-1; i>=0; i--){
            if(left > 0){
                answer[i] = div+1;
                left--;
            }else{
                answer[i] = div;
            }
        }

        return answer;
    }
}