class Solution {
    public String solution(String m, String[] musicinfos) {
        
        StringBuilder sb;
        m = convert(m);
        String answer = "(None)";
        int answerTime = 0;
        
        for(int i=0; i<musicinfos.length; i++){
            sb = new StringBuilder();
            String info[] = musicinfos[i].split(",");
            int startTime = Integer.parseInt(info[0].substring(0,2))*60 +Integer.parseInt(info[0].substring(3,5));
            int endTime = Integer.parseInt(info[1].substring(0,2))*60 +Integer.parseInt(info[1].substring(3,5));
            int playTime = endTime - startTime;
            int mLen = m.length();
            // playTime보다 m의 길이가 길면 일치하는 부분이 없으므로 할 필요가 없다.
            if(playTime < mLen) continue; 
            // 지금 값보다 크면 있어도 우선순위가 밀리니까 안해도 된다.
            if(playTime <= answerTime) continue;
            // 악보변환
            String sheet = convert(info[3]);
            // 악보길이
            int sheetLen = sheet.length();
            // // playTime이 길면 중복되는 부분이 많이 생겨서 악보길이 + 가사길이까지만 만들기
            // // playTime이 더 짧으면 거기까지만
            // int minLine = Math.min(mLen+sheetLen, playTime);

            for(int j=0; j<playTime/sheetLen; j++){
                sb.append(sheet);
            }
            
            int left = playTime%sheetLen;
            
            for(int j=0; j<left; j++){
                sb.append(sheet.charAt(j));                  
            }

            if(sb.toString().contains(m)){
                answer = info[2];
                answerTime = playTime;
            }

        }
        
        return answer;
    }
    
    public String convert(String s){
        return s.replace("B#", "b").replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
    }
        
}