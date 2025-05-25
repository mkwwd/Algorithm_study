function solution(people, limit) {
    
    people.sort((a, b) => a-b)
    
    var boat = 0;
    var left = 0;
    var right = people.length - 1;
    
    while(left <= right){
        if(people[left] + people[right] <= limit){
            left++;
        }
        right--;
        boat++;
    }
    
    
    return boat;
}