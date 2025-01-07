/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves2 = function (nums) {
  nums.sort((a, b) => a - b);
  const midNumber = nums[Math.floor(nums.length / 2)];
  let result = 0;

  for (let i = 0; i < nums.length; i++) {
    result += Math.abs(midNumber - nums[i]);
  }

  return result;
};
