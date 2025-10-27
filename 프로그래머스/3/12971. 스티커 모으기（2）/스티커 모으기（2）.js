function solution(sticker) {
    
    var N = sticker.length;
    
    if(N == 1) return sticker[0];
    if(N == 2) return Math.max(sticker[0], sticker[1]);
    
    const addFirst = Array(N-1).fill(0);
    const addLast = Array(N-1).fill(0);
    
    addFirst[0] = sticker[0];
    addFirst[1] = Math.max(sticker[0], sticker[1]);
    addLast[0] = sticker[1];
    addLast[1] = Math.max(sticker[1], sticker[2]);
     
    for(let i=2; i<N-1; i++){
        addFirst[i] = Math.max(addFirst[i-1], sticker[i] + addFirst[i-2]);
        addLast[i] = Math.max(addLast[i-1], sticker[i+1] + addLast[i-2]);
    }

    return Math.max(addFirst[N-2], addLast[N-2]);
}