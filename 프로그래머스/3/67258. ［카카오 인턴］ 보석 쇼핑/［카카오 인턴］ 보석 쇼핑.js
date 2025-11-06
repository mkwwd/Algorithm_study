function solution(gems) {
    
    const set = new Set(gems);
    const gemCount = new Map();
    
    const max = set.size;
    var answer = [0, gems.length];
    
    var left = 0;
    var right = 0;
    
    while(right < gems.length){
        gemCount.set(gems[right], (gemCount.get(gems[right]) || 0) + 1)
        right ++
        while(gemCount.size == max){
            // 구간이 더 짧으면 갱신
            if(right - left < answer[1] - answer[0]){
                answer[0] = left;
                answer[1] = right;
            }
            // 구간을 줄여보자
            if(gemCount.get(gems[left]) > 1){
                gemCount.set(gems[left], gemCount.get(gems[left]) -1)
            }else{
                gemCount.delete(gems[left]);
            }
            left++;
        }
    }
    
    answer[0]++;
    
    return answer;
}