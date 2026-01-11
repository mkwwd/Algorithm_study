class Solution {
    public int solution(int n, int[] tops) {
        
        int green = tops[0] == 0 ? 2 : 3;
        int purple = 1;
        
        for(int i=1; i<n; i++){
            int nextGreen = tops[i] == 0 ? 2*green + purple : 3*green + 2*purple;
            int nextPurple = green + purple;
            
            green = nextGreen%10007;
            purple = nextPurple%10007;
        }
        
        return (green+purple)%10007;
    }
}