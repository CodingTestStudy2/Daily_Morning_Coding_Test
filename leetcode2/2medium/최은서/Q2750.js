/**
 * @param {number[]} nums
 * @return {number}
 */

// subarray : 1이 하나만 있는 부분 배열
// 1 0 1 -> 나눌 수 없음

// 1 1 0 -> 1, 1 0

// 1 0 0 1 -> 1, 0 0 1 / 1 0, 0 1 / 1 0 0, 1 : 3가지

// 0 1 0 0 1 0 1 : (2+1)가지 * (1+1)가지 = 6가지
// 0 1 , 0 0 1, 0 1 / 0 1 0, 0 1, 0 1 / 0 1 0 0, 1, 0 1
// 0 1 , 0 0 1 0, 1 / 0 1 0, 0 1 0, 1 / 0 1 0 0, 1 0, 1
var numberOfGoodSubarraySplits = function(nums) {
    let zeroCount = 0
    let isCountable = false;
    let res = 1;
    const MOD = 1000000007;
    for (const n of nums) {
        if (n === 0 && isCountable) {
            zeroCount += 1;
        }
        else if (n === 1) {
            isCountable = true
            if (isZero !== 0) {
                res = (res * (zeroCount+1)) % MOD;
                zeroCount = 0;
            }
        }
    }
    if (!isCountable) return 0; // [0, 0] -> 0
    return finalResult;
};