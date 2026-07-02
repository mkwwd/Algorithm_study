function solution(name, yearning, photo) {
    
    const list = new Map();
    
    for(let i=0; i<name.length; i++){
        list.set(name[i], yearning[i]);
    }
    
    var answer = [];
    
    for(let i=0; i<photo.length; i++){
        let sum = 0;
        for(let j=0; j<photo[i].length; j++){
            if(list.has(photo[i][j])){
                sum += list.get(photo[i][j]);
            }
        }
        answer.push(sum);
    }
    
    return answer;
}