function solution(record) {
    
    const id = new Map();
    const rec = [];
    
    for(let i=0; i<record.length; i++){
        const input = record[i].split(" ");
        if(input[0] != "Change"){
            rec.push([input[0], input[1]]);
        }
        
        if(input[0] != "Leave"){
            id.set(input[1], input[2]);
        }
    }
    
    var answer = [];
    
    for(let i=0; i<rec.length; i++){
        let output = rec[i];
        if(output[0] == "Enter"){
            answer.push(id.get(output[1]) + "님이 들어왔습니다.")
        }else{
            answer.push(id.get(output[1]) + "님이 나갔습니다.")
        }
    }
    
    
    return answer;
}