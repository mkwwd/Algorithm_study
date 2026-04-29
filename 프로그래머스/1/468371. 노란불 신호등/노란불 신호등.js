function solution(signals) {
    
    var N = signals.length;
    var signLen = Array(N).fill(0);
    var lcm = 1;
    
    for(let i=0; i<N; i++){
        var sum = 0;
        for(let j=0; j<3; j++){
            sum += signals[i][j];
        }
        lcm *= sum/gcd(lcm, sum);
        signLen[i] = sum;
    }
    
    var answer = -1;
    
    for(let i=1; i<=lcm; i++){
        var cnt = 0;
        for(let j=0; j<N; j++){
            var mod = i%signLen[j];
            if(mod == 0) mod = signLen[j];
            if(signals[j][0] < mod && mod <= signLen[j] - signals[j][2]) cnt++;
        }
        if(cnt == N){
            answer = i;
            break;
        }
    }
    
    return answer;
}

function gcd(a , b){
    if(a%b == 0) return b;
    else return gcd(b, a%b);
}