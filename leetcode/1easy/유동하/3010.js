/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumCost = function (nums) {
  let result = Number.MAX_SAFE_INTEGER;

  for (let i = 1; i < nums.length - 1; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      result = Math.min(result, nums[i] + nums[j]);
    }
  }

  return result + nums[0];
};
