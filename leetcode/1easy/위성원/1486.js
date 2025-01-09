/**
 * @param {number} n
 * @param {number} start
 * @return {number}
 */
var xorOperation = function (n, start) {
  const nums = [];
  for (let i = 0; i < n; i++) {
    nums[i] = start + 2 * i;
  }

  let ans = nums[0];
  for (let i = 1; i < n; i++) {
    ans = ans ^ nums[i];
  }

  return ans;
};
