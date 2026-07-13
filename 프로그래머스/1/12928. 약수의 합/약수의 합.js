function solution(n) {
    var answer = findDivisor(n);
    return answer;
}

function findDivisor(num){
    var sum = 0;
    for(let i=1; i<=Math.sqrt(num); i++){
        if(num % i == 0){
            sum += i;
            if(num/i != i) sum += num/i;
        }
    }
    return sum;
}