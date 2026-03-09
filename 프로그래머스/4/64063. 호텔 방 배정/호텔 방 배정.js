const room = new Map();

function solution(k, room_number) {
    
    const answer = [];
    
    for(let i=0; i<room_number.length; i++){
        answer.push(findRoom(room_number[i]));
    }
    
    return answer;
}

function findRoom(num){
    
    if(!room.has(num)){
        room.set(num, num+1);
        return num;
    }
    
    var next = findRoom(room.get(num));
    room.set(num, next+1);
    return next;
    
}