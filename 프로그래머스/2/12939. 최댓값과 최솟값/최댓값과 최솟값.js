function solution(s) {
    
    const word = s.split(' ');
    
    return `${Math.min(...word)} ${Math.max(...word)}`;
}