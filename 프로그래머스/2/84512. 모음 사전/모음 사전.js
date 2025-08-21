function solution(word) {
    
    const vowel = ["A", "E", "I", "O", "U"]
    const count = [781, 156, 31, 6, 1]
     
    var answer = word.length;
    
    for(let i=0; i<word.length; i++){
        let index = vowel.indexOf(word[i]);
        answer += count[i]*index;
    }
  
    return answer;
}