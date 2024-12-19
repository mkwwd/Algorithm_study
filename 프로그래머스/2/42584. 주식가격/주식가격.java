import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        Deque<int[]> que = new ArrayDeque<>();
        int answer[] = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            while(!que.isEmpty()){
                int last[] = que.peekLast();
                // que의 마지막값이랑 현재값 비교해서 작아졌는지 확인
                if(last[0] > prices[i]){
                    // 크면 떨어진 것으로 답 넣어줌
                    answer[last[1]] = i - last[1];
                    que.pollLast();
                }else break;
            }
            que.add(new int[] {prices[i], i});
        }
        
        while(!que.isEmpty()){
            int now[] = que.poll();
            answer[now[1]] = answer.length-now[1] - 1;
        }
        
        return answer;
    }
}