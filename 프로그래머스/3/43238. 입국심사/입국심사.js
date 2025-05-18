function solution(n, times) {
    times.sort((a,b) => b-a)
    var answer = 0
    var min = 0
    var max = Math.max(...times)*n
    
    while(min <= max){
        var mid = Math.floor((min+max)/2)
        const cnt = times.reduce((acc, time) => acc + Math.floor(mid/time), 0)
        if(cnt >= n){
            max = mid -1
            answer = mid
        }else{
            min = mid + 1
        }
    }
    
    
    return answer;
}