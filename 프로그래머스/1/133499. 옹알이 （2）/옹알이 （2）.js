function solution(babbling) {
    
    var answer = 0;
    
    const word = ["aya", "ye", "woo", "ma"];
    const no = ["ayaaya", "yeye", "woowoo", "mama"];
    
    for(let i=0; i<babbling.length; i++){
        var str = babbling[i];
        var isPoss = true;
        for(let j=0; j<no.length; j++){
            if(str.includes(no[j])) isPoss = false;
        }
        if(!isPoss) continue;
        for(let j=0; j<word.length; j++){
            str = str.replaceAll(word[j], "O");
        }
        var cnt = 0;
        for(let j=0; j<str.length; j++){
            if(str.charAt(j) == 'O') cnt++;
        }
        if(cnt == str.length) answer++;
    }
    
    return answer;
}