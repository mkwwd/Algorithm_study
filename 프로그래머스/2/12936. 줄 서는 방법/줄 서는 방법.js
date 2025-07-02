function solution(n, k) {
    
    var fact = 1;
    var number = [];
    
    for(let i=1; i<=n; i++){
        fact *= i;
        number.push(i);
    }
    
    var answer = [];
    
    while(n > 1){
        fact /= n;
        let find = Math.ceil(k / fact)-1;
        k -= fact*(find)
        n--
        answer.push(number[find])
        number.splice(find,1)
    }
    
    answer.push(number[0])
    
    return answer;
}