function solution(money) {
    
    const len = money.length;
    
    const getFirst = Array(len).fill(0);
    const getLast = Array(len).fill(0);
    
    getFirst[0] = money[0];
    getFirst[1] = Math.max(money[0], money[1]);
    
    getLast[0] = money[1];
    getLast[1] = Math.max(money[1], money[2]);
    
    for(let i=2; i<len-1; i++){
        getFirst[i] = Math.max(getFirst[i-1], money[i] + getFirst[i-2]);
        getLast[i] = Math.max(getLast[i-1], money[i+1] + getLast[i-2]);
    }

    return Math.max(getFirst[money.length-2], getLast[money.length-2]);
}