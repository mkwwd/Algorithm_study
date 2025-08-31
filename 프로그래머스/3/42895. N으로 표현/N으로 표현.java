import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        if(N == number) return 1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        
        for(int i=0; i<9; i++){
            dp.add(new HashSet<>());
        }
        
        int n = N;
        int answer = -1;
        
        for(int i=1; i<9; i++){
            if(i==1){
                dp.get(i).add(n);
            }else{
                n = n*10 + N;
                dp.get(i).add(n);
            } 
            
            for(int j=1; j<i; j++){
                for(int a : dp.get(j)){
                    for(int b : dp.get(i-j)){
                        dp.get(i).add(a+b);
                        dp.get(i).add(a-b);
                        dp.get(i).add(a*b);
                        if(b != 0) dp.get(i).add(a/b);
                    }
                }
            }
            
            if(dp.get(i).contains(number)){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}