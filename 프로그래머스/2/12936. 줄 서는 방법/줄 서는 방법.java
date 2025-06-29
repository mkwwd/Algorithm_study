import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        
        long fac = 1;
        ArrayList<Integer> number = new ArrayList<>();
        
        for(int i=1; i<n+1; i++){
            fac *= i;
            number.add(i);
        }
        
        int index = 0;
        int answer[] = new int[n];
        
        while(n > 1){
            
            fac /= n;
            int find = (int)((k-1) / fac);
            answer[index++] = number.remove(find);
            n--;
            k -= fac*(find);          
        }
        
        answer[index] = number.get(0);
        
        
        return answer;
    }
    

}