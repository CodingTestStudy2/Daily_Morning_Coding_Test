/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var countKConstraintSubstrings = function (s, k) {
  const checkSatisfyConstraint = (sub) => {
    let zeroCount = 0;
    let oneCount = 0;

    for (const char of sub) {
      if (char === "1") {
        oneCount++;
      } else {
        zeroCount++;
      }
    }

    return zeroCount <= k || oneCount <= k
  }

  let answer = 0;
  for (let i = 0; i < s.length; i++) {
    for (let j = i + 1; j <= s.length; j++) {
      const sub = s.slice(i, j);

      if (checkSatisfyConstraint(sub)) {
        answer++;
      }
    }
  }

  return answer;
};