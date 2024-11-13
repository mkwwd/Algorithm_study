import java.util.*;

class Solution {
    
    boolean[] visited;
    HashSet<Integer> prime = new HashSet<>();
    
    public int solution(String numbers) {
        
        visited = new boolean[numbers.length()];
            
        for(int i=1; i<=numbers.length(); i++){
            permutation(i, "", numbers);
        }
        
        return prime.size();
    }
    
    public void permutation(int len, String word, String numbers){
        
        if(word.length() == len){
            int num = Integer.parseInt(word);
            if(isPrime(num)){
                prime.add(num);
            };
            return;
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            permutation(len, word+numbers.charAt(i), numbers);
            visited[i] = false;
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