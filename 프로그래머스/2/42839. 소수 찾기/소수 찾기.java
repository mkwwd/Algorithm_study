import java.util.*;

class Solution {
    
    boolean[] used;
    HashSet<Integer> prime = new HashSet<>();
    
    public int solution(String numbers) {
        
        used = new boolean[numbers.length()];
            
        for(int i=1; i<=numbers.length(); i++){
            permutation(i, "", numbers);
        }
        
        return prime.size();
    }
    
    public void permutation(int len, String str, String numbers){
        
        if(len == str.length()){
            int num = Integer.parseInt(str);
            if(isPrime(num)) prime.add(num);
            return;
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(used[i]) continue;
            used[i] = true;
            permutation(len, str+numbers.charAt(i), numbers);
            used[i] = false;
        }
        
    }
    
    public boolean isPrime(int num){
        if(num <= 1) return false;
        if(num == 2) return true;
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }
        
        return true;
    }

}