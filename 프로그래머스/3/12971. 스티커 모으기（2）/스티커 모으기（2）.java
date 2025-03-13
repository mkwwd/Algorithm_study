import java.util.*;

class Solution {
    public int solution(int sticker[]) {

        int N = sticker.length;
        
        if(N == 1){
            return sticker[0];
        }else if(N == 2){
            return Math.max(sticker[0], sticker[1]);
        }

        int[] addFirst = new int[N-1];
        int[] addLast = new int[N-1];
        
        addFirst[0] = sticker[0];
        addFirst[1] = Math.max(sticker[0], sticker[1]);
        addLast[0] = sticker[1];
        addLast[1] = Math.max(sticker[1], sticker[2]);
        
        for(int i=2; i<N-1; i++){
            addFirst[i] = Math.max(sticker[i] + addFirst[i-2], addFirst[i-1]);
            addLast[i] = Math.max(sticker[i+1] + addLast[i-2], addLast[i-1]);
        }
        
        return Math.max(addFirst[N-2], addLast[N-2]);
    }
}