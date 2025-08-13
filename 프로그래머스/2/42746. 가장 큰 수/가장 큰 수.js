function solution(numbers) {
    
    const num = Array.from({length : numbers.length}).fill("");
    
    for(let i=0; i< num.length; i++){
        num[i] = numbers[i]+"";
    }
    
    num.sort((o1, o2) => (o2+o1).localeCompare(o1+o2));
    
    if(num[0] == "0") return "0";
    
    var answer = num.join("");

    return answer;
}