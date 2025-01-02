/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumCost = function (nums) {
  const n = nums.length;
  let minCost = Infinity;
  for (let i = 1; i < n - 1; i++) {
    for (let j = i + 1; j < n; j++) {
      const cost = nums[0] + nums[i] + nums[j];
      minCost = Math.min(minCost, cost);
    }
  }
  return minCost;
};
