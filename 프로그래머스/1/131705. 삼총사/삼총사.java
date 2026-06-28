class Solution {
    
    static int answer;
    static boolean find[];
    
    public int solution(int[] number) {
        
        answer = 0;
        find = new boolean[number.length];
        
        combination(0, 0, number);
        
        return answer;
    }
    
    public void combination(int st, int cnt, int[] number){
        
        if(cnt == 3){
            int sum = 0;
            for(int i=0; i<find.length; i++){
                if(find[i]){
                    sum += number[i];
                }
            }
            if(sum == 0) answer++;
            return;
        }
        
        for(int i=st; i<number.length; i++){
            find[i] = true;
            combination(i+1, cnt+1, number);
            find[i] = false;
        }
        
    }
}