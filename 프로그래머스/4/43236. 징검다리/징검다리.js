function solution(distance, rocks, n) {
    
    rocks.push(distance)
    rocks.sort((a,b) => a-b)
    
    var answer = 0
    var min = 1
    var max = distance
    
    while(min <= max){
        var start = 0
        var cnt = 0
        var dis = 0
        var mid = Math.floor((min+max)/2)
        for(let i=0; i<rocks.length; i++){
            dis += rocks[i] - start
            if(dis < mid){
                cnt++
            }else{
                dis = 0
            }
            start = rocks[i]
        }
        
        if(cnt > n){
            max = mid-1
        }else{
            answer = mid
            min = mid+1
        }
    }
    
    return answer
}