import java.util.*;

class Solution {
    
    static TreeSet<Integer> set;
    static int answer = 0;
    
    public int solution(int[] arrayA, int[] arrayB) {
        
        set = new TreeSet<>(Collections.reverseOrder());
        
        int num = arrayA[0];
        
        for(int i=1; i<arrayA.length; i++){
            num = gcd(num, arrayA[i]);
        }
        
        findDiv(num);
        findMax(arrayB);
        set.clear();
        
        num = arrayB[0];
        
        for(int i=1; i<arrayB.length; i++){
            num = gcd(num, arrayB[i]);
        }
        
        findDiv(num);
        findMax(arrayA);
            
        return answer;
    }
    
    public int gcd(int a, int b){
        if(a%b == 0) return b;
        else return gcd(b, a%b);
    }
    
    public void findDiv(int num){
        for(int i=1; i<= Math.sqrt(num); i++){
            if(num%i == 0){
                set.add(i);
                set.add(num/i);
            }
        }
    }
    
    public void findMax(int arr1[]){
        for(int div : set){
            int cnt = 0;
            int len = arr1.length;
            for(int i=0; i<len; i++){
                if(arr1[i]%div != 0) cnt++;
            }
            if(cnt == len) {
                answer = Math.max(answer, div);
                break;
            }
        }
    }
    
}