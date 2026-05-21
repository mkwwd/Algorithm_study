function solution(n, k) {
    
    var permu = 1;
    const people = [];
    
    for(let i=1; i<=n; i++){
        permu *= i;
        people.push(i);
    }
    
    var answer = [];
    
    while(people.length){
        if(people.length == 1){
            answer.push(people.pop());
            break;
        }
        
        permu /= people.length;
        var num = Math.floor((k-1)/permu);
        answer.push(people[num]);
        k -= num*permu;
        people.splice(num,1);
    }
    
    return answer;
}