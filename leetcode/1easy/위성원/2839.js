/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var canBeEqual = function (s1, s2) {
  if (s1 === s2) {
    return true;
  }

  let answer = false;
  const dfs = (prevI, prevJ, swaped, s2, count) => {
    if (count > 6) {
      return;
    }

    if (swaped === s2) {
      answer = true;
      return true;
    }

    if (prevI === 0 && prevJ === 2) {
      const newS = `${swaped[0]}${swaped[3]}${swaped[2]}${swaped[1]}`;
      dfs(1, 3, newS, s2, count + 1);
    } else {
      const newS = `${swaped[2]}${swaped[1]}${swaped[0]}${swaped[3]}`;
      dfs(0, 2, newS, s2, count + 1);
    }
  };

  const newS = `${s1[2]}${s1[1]}${s1[0]}${s1[3]}`;
  dfs(0, 2, newS, s2, 1);
  return answer;
};
