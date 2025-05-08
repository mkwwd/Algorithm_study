function solution(nums) {
    
    var map = new Map();
    
    for(let i=0; i<nums.length; i++){
        if(map.has(nums[i])){
            map.set(nums[i], map.get(nums[i]) + 1);
        }else{
            map.set(nums[i], 1);
        }
    }
    
    var answer = 0;
    
    if(map.size > nums.length/2){
        answer = nums.length/2
    }else{
        answer = map.size
    }
    
    return answer;
}