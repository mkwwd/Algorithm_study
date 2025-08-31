function solution(N, number) {
    
    if(N == number) return 1;
    
    const arr = Array.from({length : 9}, () => new Set());
    
    var n = N +"";
    var answer = -1;
    
    for(let i=1; i<9; i++){
        arr[i].add(Number.parseInt(n.repeat(i)));
        
        for(let j=1; j<i; j++){
            for(const a of arr[j]){
                for(const b of arr[i-j]){
                    arr[i].add(a+b)
                    arr[i].add(a-b)
                    arr[i].add(a*b)
                    if(b != 0) arr[i].add(Math.floor(a/b))
                }
            }
        }
        
        if(arr[i].has(number)){
            answer = i
            break
        }

    }
    
    return answer;
}