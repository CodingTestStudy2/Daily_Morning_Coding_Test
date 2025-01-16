/**
 * @param {number[][]} mat
 * @return {number}
 */
var numSpecial = function (mat) {
  let ans = 0;
  const m = mat.length;
  const n = mat[0].length;

  const checkIsSpecial = (i, j) => {
    if (mat[i][j] !== 1) {
      return false;
    }

    const row = mat[i];
    const filteredRow = row.filter((number) => number === 1);

    if (filteredRow.length !== 1) {
      return false
    }

    // 세로 탐색 
    let oneCount = 0;
    mat.forEach((row) => {
      if (row[j] === 1) {
        oneCount++;
      }
    })

    if (oneCount !== 1) {
      return false;
    }

    return true;
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (checkIsSpecial(i, j)) {
        ans++
      }
    }
  }

  return ans;
};