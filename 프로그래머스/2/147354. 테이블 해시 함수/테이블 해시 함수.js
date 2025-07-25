function solution(data, col, row_begin, row_end) {
    
    const index = col-1;
    
    data.sort((a,b) => {
        if(a[index] == b[index]){
            return b[0] - a[0];
        }else{
            return a[index] - b[index];
        }
    })
    
    var answer = 0;
    
    for(let i=row_begin-1; i<row_end; i++){
        let sum = 0;
        data[i].forEach((num) => {
            sum += num%(i+1)
        })
        answer = (answer^sum)
    }
    
    return answer;
}