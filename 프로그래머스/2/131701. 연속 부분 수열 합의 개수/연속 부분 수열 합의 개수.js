function solution(elements) {
    
    var arr = new Map();
    const n = elements.length;
    
    for(let i=0; i<n; i++){
        var sum = elements[i];
        arr.set(sum);
        for(let j=i+1; j<i+n; j++){
            sum+=elements[j%n];
            arr.set(sum);
        }
    }
    
    return arr.size;
}