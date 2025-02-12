class Solution {
    public int solution(int[] money) {
        
        int[] getFirst = new int[money.length+1];
        int[] getLast = new int[money.length+1];
        
        for(int i=0; i<money.length-1; i++){
            getFirst[i+1] = money[i];
            getLast[i+1] = money[i+1];
        }
        
        for(int i=2; i<=money.length; i++){
            getFirst[i] = Math.max(getFirst[i] + getFirst[i-2], getFirst[i-1]);
            getLast[i] = Math.max(getLast[i] + getLast[i-2], getLast[i-1]);
        }
        
        return Math.max(getFirst[money.length], getLast[money.length]);
    }
}