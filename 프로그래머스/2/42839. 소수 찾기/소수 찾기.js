var used;
var map = new Map();

function solution(numbers) {
    
    used = Array(numbers.length).fill(false);
    
    for(let i=1; i<=numbers.length; i++){
        permutation(i, "", numbers);
    }
    
    return map.size;
}

function permutation(len, str, numbers){
    
    if(str.length == len){
        var num = Number(str);
        if(isPrime(num)) map.set(num);
        return;
    }
    
    for(let i=0; i<numbers.length; i++){
        if(used[i]) continue;
        used[i] = true;
        permutation(len, str+numbers.charAt(i), numbers);
        used[i] = false;
    }
    
}

function isPrime(num){
    
    if(num <= 1) return false;
    if(num == 2) return true;
    
    for(let i=2; i<=Math.sqrt(num); i++){
        if(num % i == 0) return false;
    }
    
    return true;
}
