function solution(m, musicinfos) {
    
    var answer = "(None)";
    var maxPlayTime = 0;
    m = convert(m);
    var melodyLen = m.length;
    
    for(let i=0; i<musicinfos.length; i++){
        var s = "";
        const info = musicinfos[i].split(",");
        var start = info[0].substring(0, 2)*60 + info[0].substring(3, 5)*1;
        var end = info[1].substring(0, 2)*60 + info[1].substring(3, 5)*1;
        var playTime = end - start;
        
        if(maxPlayTime >= playTime) continue;
        if(melodyLen > playTime) continue;

        var sheet = convert(info[3]);
        var sheetLen = sheet.length;
        
        for(let j=0; j<Math.floor(playTime/sheetLen); j++){
            s += sheet;
        }
        
        var mod = playTime%sheetLen;
        s += sheet.substring(0, mod);

        if(s.includes(m)){
            answer = info[2];
            maxPlayTime = playTime;
        }
    }
    
    return answer;
}

function convert(s){
    return s.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#", "a").replaceAll("B#", "b");
}