import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        String change = Integer.toString(n, k);
        
        String arr[] = change.split("0");
        
        int answer = 0;
        
        for(int i=0; i<arr.length; i++){
            if(!arr[i].isEmpty() && !arr[i].equals("1")){
                if(isPrime(arr[i])) answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(String str){
        
        long num = Long.parseLong(str);
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }
        
        return true;
    }
}