class Solution {
    public double solution(int[] arr) {
        
        int sum = 0;
        int len = arr.length;
        
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        
        double answer = (double)sum/len;
        
        return answer;
    }
}