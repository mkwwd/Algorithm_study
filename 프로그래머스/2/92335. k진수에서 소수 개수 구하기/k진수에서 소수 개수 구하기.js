function solution(n, k) {
    
    const str = n.toString(k);
    
    const arr = str.split("0");
    
    var answer = 0;
    
    for(let i=0; i<arr.length; i++){
        if(arr[i].length && arr[i] != "1"){
            if(isPrime(arr[i])) answer++;
        }
    }
    
    return answer;
}

function isPrime(str){
    
    const num = str;
    
    for(let i=2; i<= Math.sqrt(num); i++){
        if(num % i == 0) return false;
    }
    
    return true;
    
}