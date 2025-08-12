/**
 * @param {number[]} nums
 * @return {number}
 */
var sumFourDivisors = function(nums) {
    let result = 0; // BigInt
    for (const n of nums) {
        let cnt = 0;
        let tot = 0;
        const TARGET = 4
        for (let i = 1; i*i <= n; i++) {
            if (cnt > TARGET) {
                break;
            }
            if ((n/i) === i) { //4, 16, 25 .. 등은 몫의 개수가 4가 나올 수 없음
                cnt += 1;
                break; 
            }
            if (n % i === 0 && (n/i) !== (i)) {
                cnt += 2;
                tot = tot + (i + (n / i))
            }
        }
        if (cnt === TARGET) {
            result += tot;
        }
    }
    return result;
};