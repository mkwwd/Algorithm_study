function solution(s) {
    
    const word = s.split(' ');
    
    word.sort((a, b) => a - b);
    
    return `${word[0]} ${word[word.length-1]}`;
}