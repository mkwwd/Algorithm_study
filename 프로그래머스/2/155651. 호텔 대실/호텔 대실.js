function solution(book_time) {
    
    const time = Array.from({length : book_time.length}, () => Array(2).fill(0));
    
    for(let i=0; i<book_time.length; i++){
        let startTime = book_time[i][0].split(":");
        let endTime = book_time[i][1].split(":");
        time[i][0] = Number.parseInt(startTime[0])*60 + Number.parseInt(startTime[1])
        time[i][1] = Number.parseInt(endTime[0])*60 + Number.parseInt(endTime[1]) +10
    }
    
    time.sort((a, b) => {
        if(a[0] == b[0]){
            return a[1] - b[1]
        }else{
            return a[0] - b[0]
        }
    })
    
    const hotel = [];
    
    for(let i=0; i<time.length; i++){
        if(hotel.length == 0){
            hotel.push(time[i][1])
        }else{
            hotel.sort((a,b) => a-b);
            if(hotel[0] <= time[i][0]){
                hotel.shift()
            }
            hotel.push(time[i][1])
        }
    }
    
    return hotel.length;
}