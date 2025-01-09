/**
 * @param {number} n
 * @param {number} start
 * @return {number}
 */
var xorOperation = function (n, start) {
  var nums = new Array(n).fill(0);
  for (let i = 0; i < n; i++) {
    nums[i] = start + 2 * i;
  }
  var result = 0;
  for (num of nums) {
    result ^= num;
  }

  console.log(result);
  return result;
};
