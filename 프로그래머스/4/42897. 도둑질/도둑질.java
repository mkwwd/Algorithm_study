class Solution {
    public int solution(int[] money) {
        
        int getFirst[] = new int[money.length];
        int getLast[] = new int[money.length];
        
        getFirst[0] = money[0];
        getFirst[1] = Math.max(money[0], money[1]);
        
        getLast[0] = money[1];
        getLast[1] = Math.max(money[1], money[2]);
        
        for(int i=2; i<money.length-1; i++){
            getFirst[i] = Math.max(money[i] + getFirst[i-2], getFirst[i-1]);
            getLast[i] = Math.max(money[i+1] + getLast[i-2], getLast[i-1]);
        }
        
        return Math.max(getFirst[money.length-2], getLast[money.length-2]);
        
    }
}