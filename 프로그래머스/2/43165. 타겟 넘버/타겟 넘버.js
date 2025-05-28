var answer = 0;

function solution(numbers, target) {
    
    dfs(0, 0, numbers, target)
    
    return answer
}

function dfs(index, sum, numbers, target){
    
    if(index == numbers.length){
        if(sum == target){
            answer++
        }
        return
    }
    
    dfs(index+1, sum+numbers[index], numbers, target)
    dfs(index+1, sum-numbers[index], numbers, target)
    
}