class Solution {
    public int solution(String[] babbling) {
        
        int answer = 0;
        
        String word[] = {"aya", "ye", "woo", "ma"};
        String no[] = {"ayaaya", "yeye", "woowoo", "mama"};
        
        for(int i=0; i<babbling.length; i++){
            String str = babbling[i];
            boolean isPoss = true;
            for(int j=0; j<no.length; j++){
                if(str.contains(no[j])) isPoss = false;
            }
            if(!isPoss) continue;
            for(int j=0; j<word.length; j++){
                if(str.length() > 0){
                    str = str.replace(word[j], "O");
                }
            }
            int cnt = 0;
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == 'O') cnt++;
            }
            if(cnt == str.length()) answer++;
        }
        
        return answer;
    }
}