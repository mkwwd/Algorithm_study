function solution(s, n) {
    
    var answer = '';
    
    for(let i=0; i<s.length; i++){
        let char = s.charAt(i);
        let ascii = char.charCodeAt(0);
        if(ascii >= 65 && ascii <= 90){
            ascii -= 65;
            ascii = (ascii+n)%26;
            ascii += 65;
        }else if(ascii >= 97 && ascii <= 122){
            ascii -= 97;
            ascii = (ascii+n)%26;
            ascii += 97;
        }else{
            answer = answer + ' ';
            continue;
        }
        answer = answer + String.fromCharCode(ascii);
    }
    
    return answer;
}