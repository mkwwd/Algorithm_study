class Solution {
    public int solution(int[] money) {
        
        int len = money.length;
        
        int getFirst[] = new int[len];
        int getLast[] = new int[len];
        
        getFirst[0] = money[0];
        getFirst[1] = Math.max(money[0], money[1]);
        
        getLast[0] = money[1];
        getLast[1] = Math.max(money[1], money[2]);
        
        for(int i=2; i<len-1; i++){
            getFirst[i] = Math.max(getFirst[i-1], getFirst[i-2]+money[i]);
            getLast[i] = Math.max(getLast[i-1], getLast[i-2]+money[i+1]);
        }
        
        return Math.max(getFirst[len-2], getLast[len-2]);
    }
}