function solution(n) {
    
    const fn = Array.from({length : n+1}).fill(0)
    const div = 1234567;
    
    fn[1] = 1;
    
    for(let i=2; i<=n; i++){
        fn[i] = (fn[i-2] + fn[i-1])%div;
    }

    return fn[n];
}