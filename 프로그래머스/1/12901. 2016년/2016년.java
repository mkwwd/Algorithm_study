class Solution {
    public String solution(int a, int b) {
        
        String day[] = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int sum = 0;
        
        for(int i=0; i<a-1; i++){
            sum += month[i];
        }
        
        sum += b;
        
        int findDay = sum%7;
        
        String answer = day[findDay];
        
        return answer;
    }
}