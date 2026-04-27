function solution(people, limit) {
    
    people.sort((a, b) => a-b);
    
    var left = 0;
    var right = people.length -1;
    var boat = 0;
    
    while(left <= right){
        
        if(people[left] + people[right] <= limit){
            left ++;
        }
        
        right--;
        boat++;
        
    }
    
    return boat;
}