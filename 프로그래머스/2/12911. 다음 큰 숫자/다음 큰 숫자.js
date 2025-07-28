function solution(n) {
    
    var bin = n.toString(2)
    bin = bin.replaceAll("0","")
    var len = bin.length
    var answer = 0
    
    while(true){
        n++
        var next = n.toString(2)
        next = next.replaceAll("0","")
        var nextLen = next.length
        if(len == nextLen){
            answer = n
            break
        }
    }
    
    return answer;
}