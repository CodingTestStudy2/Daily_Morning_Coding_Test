/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var sumBase = function(n, k) {
    const changedNumStr=n.toString(k)
    return changedNumStr.split('').reduce((acc,cur)=>acc+Number(cur),0);
};