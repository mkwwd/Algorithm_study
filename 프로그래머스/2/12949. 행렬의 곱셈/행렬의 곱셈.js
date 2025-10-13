function solution(arr1, arr2) {
    
    var n = arr1.length;
    var m = arr2[0].length;
    var x = arr1[0].length;
    
    var answer = Array.from({length : n}, () => Array(m).fill(0));
    
    for(let i=0; i<n; i++){
        for(let j=0; j<m; j++){
            for(let k=0; k<x; k++){
                answer[i][j] += arr1[i][k] * arr2[k][j];
            }
        }
    }
    
    return answer;
}