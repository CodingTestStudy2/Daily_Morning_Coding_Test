/**
 * @param {number[][]} nums
 * @return {number[]}
 */
var findDiagonalOrder = function (nums) {
  const res = [];
  const ans = [];
  for (let i = 0; i < nums.length; i++) {
    const row = nums[i];
    for (let j = 0; j < row.length; j++) {
      const s = i + j;
      if (!res[s]) res[s] = [];
      res[s].push(row[j]);
    }
  }
  const result = [];
  for (let i = 0; i < res.length; i++) {
    for (let j = 0; j < res[i].length; j++) {
      console.log(res[i][res[i].length - 1 - j]);
      result.push(res[i][res[i].length - 1 - j]);
    }
  }
  return result;
};
