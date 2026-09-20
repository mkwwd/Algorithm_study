function solution(nums) {
    
    var get = Math.floor(nums.length/2);
    var map = new Map();
    
    for(let i=0; i<nums.length; i++){
        if(map.has(nums[i])){
            map.set(nums[i], map.get(nums[i])+1);
        }else{
            map.set(nums[i], 1);
        }
    }
    
    var size = map.size;
    var answer = Math.min(size, get);
    
    return answer;
}