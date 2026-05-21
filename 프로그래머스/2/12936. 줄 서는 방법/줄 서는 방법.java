import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        
        ArrayList<Integer> people = new ArrayList<>();
        long permu = 1;
        
        for(int i=1; i<=n; i++){
            permu *= i;
            people.add(i);
        }
        
        int index = 0;
        int answer[] = new int[n];
        
        while(people.size() > 0){
            
            if(people.size() == 1){
                answer[index] = people.get(0);
            }
            
            permu /= people.size();
            int num = (int)((k-1)/permu);
            answer[index] = people.remove(num);
            index++;
            k -= num*permu;
        }
        
        return answer;
        
    }

}