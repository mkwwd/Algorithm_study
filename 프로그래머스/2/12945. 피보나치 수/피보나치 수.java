class Solution {
    public int solution(int n) {
        
        int fn[] = new int[n+1];
        int div = 1234567;
        
        fn[0] = 0;
        fn[1] = 1;
        
        for(int i=2; i<=n; i++){
            fn[i] = (fn[i-2] + fn[i-1])%div;
        }
       
        return fn[n];
    }
}