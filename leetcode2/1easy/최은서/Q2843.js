/**
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
var countSymmetricIntegers = function(low, high) {
    let cnt = 0;
    for (let i = low; i <= high; i++) { //O(n)
        if (i.toString().length % 2 !== 0) continue;
        const mid = i.toString().length / 2
        const left = i.toString().substring(0, mid)
        const right = i.toString().substring(mid, i.length)
        const sum = str => [...str].reduce((acc, ch) => acc + Number(ch), 0); //O(m)
        if (sum(left) === sum(right)) cnt += 1
    }
    return cnt
    
};