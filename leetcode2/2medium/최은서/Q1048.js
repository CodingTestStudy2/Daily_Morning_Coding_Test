/**
 * @param {string[]} words
 * @return {number}
 */
var longestStrChain = function(words) {
    const dp = new Map()
    words.sort((a, b) => a.length - b.length) //문자 길이가 짧은 순서로 정렬
    let maxLen = 1; //가장 긴 체인 문자열 길이
    for (const word of words) {
        let best = 1;
        for (let i = 0; i< word.length; i++) {
            const sub = word.slice(0, i) + word.slice(i+1, word.length)
            if (dp.has(sub)) {
                best = Math.max(best, dp.get(sub) + 1) 
            }
            dp.set(word, best);
            maxLen = Math.max(maxLen, best)
        } 
    }
    // dp .. a : 1, ab : 2, ac : 1, abc : 2 -> 3
    return maxLen;

};