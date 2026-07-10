function solution(a, b) {
    
    const day = ["THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"];
    const month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    
    var sum = 0;
    
    for(let i=0; i<a-1; i++){
        sum += month[i];
    }
    
    sum += b;
    
    var findDay = sum%7;
    var answer = day[findDay];
    
    return answer;
}