/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var canBeEqual = function (s1, s2) {
  if (s1 === s2) return true;
  const c1 = s2.split("");
  if (s1 === c1[0] + c1[3] + c1[2] + c1[1]) return true;
  if (s1 === c1[2] + c1[1] + c1[0] + c1[3]) return true;
  if (s1 === c1[2] + c1[3] + c1[0] + c1[1]) return true;
  return false;
};
