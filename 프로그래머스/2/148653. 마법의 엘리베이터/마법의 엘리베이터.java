class Solution {
    public int solution(int storey) {
        
        int cnt = 0;

        while(storey != 0){
            
            int left = storey % 10;
            storey /= 10;
            
            if(left == 0) continue;
            
            if(left > 5){
                storey ++;
                cnt += 10 - left;
            }else if(left < 5){
                cnt += left;
            }else{
                if(storey % 10 >= 5){
                    storey ++;
                }
                cnt += left;
            }
        }
        
        return cnt;
    }
}