class Solution {
    public boolean solution(int x) {
        
        String str = Integer.toString(x);
        String arr[] = str.split("");
        
        int sum = 0;
        
        for(int i=0; i<arr.length; i++){
            sum += Integer.parseInt(arr[i]);
        }
        
        boolean answer = false;
        if(x%sum == 0) answer = true; 
        
        return answer;
    }
}