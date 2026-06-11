function solution(s, skip, index) {
    
    var alphabet = [];
    
    for(let i=97; i<=122; i++){
        alphabet.push(String.fromCharCode(i));
    }
    
    alphabet = alphabet.filter((char) => !skip.includes(char));
    
    var answer = '';
    
    for(let i=0; i<s.length; i++){
        var idx = alphabet.indexOf(s.charAt(i));
        idx = (idx + index)%alphabet.length;
        answer += alphabet[idx];
    }
    
    return answer;
}