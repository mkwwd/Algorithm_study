var answer = 0;

function solution(arrayA, arrayB) {
    
    var num = arrayA[0];
    
    for(let i=1; i<arrayA.length; i++){
        num = gcd(arrayA[i], num);
    }
    
    findMax(num, arrayB);
    
    num = arrayB[0];
    
    for(let i=1; i<arrayB.length; i++){
        num = gcd(arrayB[i], num);
    }
    
    findMax(num, arrayA);

    return answer;
}

function gcd(a, b){
    if(a%b == 0) return b;
    else return gcd(b, a%b);
}

function findMax(num, array){
    for(let i=1; i<=Math.sqrt(num); i++){
        if(num % i == 0){
            checkPos(Math.floor(num/i), array);
            checkPos(i, array);
        }
    }
}

function checkPos(num, array){
    var cnt = 0;
    for(let i=0; i<array.length; i++){
        if(array[i]%num !== 0) cnt++
    }
    if(cnt == array.length) {
        answer = Math.max(answer, num);
    }
}
