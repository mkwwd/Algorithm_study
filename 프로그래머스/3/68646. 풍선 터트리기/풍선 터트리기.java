class Solution {
    public int solution(int[] a) {
        
        int len = a.length;
        
        int frontMin[] = new int[len];
        int backMin[] = new int[len];
        
        frontMin[0] = a[0];
        for(int i=1; i<len; i++){
            frontMin[i] = Math.min(frontMin[i-1], a[i]);
        }
        
        backMin[len-1] = a[len-1];
        for(int i=len-2; i>=0; i--){
            backMin[i] = Math.min(backMin[i+1], a[i]);
        }
        
        int answer = 0;
        
        for(int i=0; i<len; i++){
            if(a[i] == frontMin[i] || a[i] == backMin[i]) answer++;
        }
         
        return answer;
    }
}