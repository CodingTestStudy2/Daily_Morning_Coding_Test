/**
 * @param {number[]} nums
 * @return {number}
 */
var findNonMinOrMax = function (nums) {
  if (nums.length < 3) {
    return -1
  }

  let min = Infinity
  let max = -1

  for (let i = 0; i < nums.length; i++) {
    const num = nums[i];
    if (num > max) {
      max = num
    }

    if (min > num) {
      min = num;
    }
  }

  for (const num of nums) {
    if (num !== min && num !== max) {
      return num
    }
  }

  return -1;
};