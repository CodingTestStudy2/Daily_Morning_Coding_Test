/**
 * @param {number[]} nums
 * @return {number}
 */

// 풀이 실패 solutions 참고
var minimumCost = function (nums) {
  let min1 = Infinity,
    min2 = Infinity;
  for (let i = 1; i < nums.length; i++) {
    const currentValue = nums[i];
    if (currentValue < min1) {
      min2 = min1;
      min1 = currentValue;
    } else if (currentValue < min2) {
      min2 = nums[i];
    }
  }
  return nums[0] + min1 + min2;
};
