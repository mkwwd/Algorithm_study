import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        int N = numbers.length;
        int answer[] = new int[N];
        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=N-1; i>=0; i--){
            
            while(!stack.isEmpty() && numbers[i] >= stack.peek()){
                stack.pop();
            }
            
            if(!stack.isEmpty()){
                answer[i] = stack.peek();
            }
            
            stack.push(numbers[i]);
        }
        
        
        return answer;
    }
}