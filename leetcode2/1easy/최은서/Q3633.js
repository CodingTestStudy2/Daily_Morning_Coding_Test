/**
 * @param {number[]} landStartTime
 * @param {number[]} landDuration
 * @param {number[]} waterStartTime
 * @param {number[]} waterDuration
 * @return {number}
 */
var earliestFinishTime = function(landStartTime, landDuration, waterStartTime, waterDuration) {
    function getEndTime(startTime1, startTime2, duration1, duration2) {
        let miniTime = 1000000;
        for (let i = 0; i < startTime1.length; i++) {
            for (let j = 0; j < startTime2.length; j++) {
                const start1 = startTime1[i]; //기구 1의 시작 시간
                const finish1 = start1 + duration1[i] //기구 1의 종료 시간

                const start2 = Math.max(finish1, startTime2[j]); //기구 2의 시작 시간
                const finish2 = start2 + duration2[j]; //기구2의 종료 시간
                
                miniTime = Math.min(finish2, miniTime);
            }
        }
        return miniTime
    }
    //land -> water
    let res1 = getEndTime(landStartTime, waterStartTime, landDuration, waterDuration);

    //water -> land
    let res2 = getEndTime(waterStartTime, landStartTime, waterDuration, landDuration);
    return Math.min(res1, res2);

};