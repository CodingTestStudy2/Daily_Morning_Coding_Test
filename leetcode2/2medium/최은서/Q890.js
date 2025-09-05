/**
 * @param {string[]} words
 * @param {string} pattern
 * @return {string[]}
 */
var findAndReplacePattern = function (words, pattern) {
  const res = [];
  for (const w of words) {
    const pm = new Map(); //pattern -> word
    const wm = new Map(); //word -> pattern
    let flag = false;
    for (let i = 0; i < w.length; i++) {
      //각 문자 하나씩 비교
      if (
        (pm.has(pattern[i]) && pm.get(pattern[i]) !== w[i]) || // pattern -> word 혹은 word -> pattern에서 중복 발생
        (wm.has(w[i]) && wm.get(w[i]) !== pattern[i])
      ) {
        flag = true;
      }
      if (flag) break;
      pm.set(pattern[i], w[i]);
      wm.set(w[i], pattern[i]);
    }
    if (!flag) res.push(w);
  }
  return res;
};
