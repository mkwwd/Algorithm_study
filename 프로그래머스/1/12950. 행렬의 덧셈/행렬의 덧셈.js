function solution(arr1, arr2) {
    
    let col = arr1.length;
    let row = arr1[1].length;
    
    var answer = Array.from({length:col}, () => Array(row).fill(0));
    
    for(let i=0; i<col; i++){
        for(let j=0; j<row; j++){
            answer[i][j] = arr1[i][j] + arr2[i][j];
        }
    }
    
    return answer;
}