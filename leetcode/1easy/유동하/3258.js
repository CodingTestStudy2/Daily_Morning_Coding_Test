/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var countKConstraintSubstrings = function (s, k) {
  let result = 0;

  for (let i = 0; i < s.length; i++) {
    let one = 0;
    let zero = 0;

    for (let j = i; j < s.length; j++) {
      if (s[j] === "0") {
        zero++;
      } else {
        one++;
      }

      if (one <= k || zero <= k) {
        result++;
      }
    }
  }

  return result;
};
