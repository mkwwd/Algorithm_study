class Solution {
    public String solution(String m, String[] musicinfos) {
        
        StringBuilder sb;
        m = convert(m);
        String answer = "(None)";
        int maxPlayTime = 0;
        
        for(int i=0; i<musicinfos.length; i++){
            sb = new StringBuilder();
            String info[] = musicinfos[i].split(",");
            int start = Integer.parseInt(info[0].substring(0,2))*60 + Integer.parseInt(info[0].substring(3,5));
            int end = Integer.parseInt(info[1].substring(0,2))*60 + Integer.parseInt(info[1].substring(3,5));

            int playLen = end - start;
            int melodyLen = m.length();
            
            if(playLen < melodyLen) continue;
            if(playLen <= maxPlayTime) continue;
            
            String sheet = convert(info[3]);
            int sheetLen = sheet.length();
            
            for(int j=0; j<playLen/sheetLen; j++){
                sb.append(sheet);
            }
            
            int mod = playLen%sheetLen;
            sb.append(sheet.substring(0, mod));
            
            if(sb.toString().contains(m)){
                answer = info[2];
                maxPlayTime = playLen;
            }
            
        }
        
        return answer;
    }
    
    public String convert(String s){
        return s.replace("B#","b").replace("C#", "c").replace("D#","d").replace("F#","f").replace("G#", "g").replace("A#", "a");
    }

}