/**
 * @param {number[]} nums
 * @return {number}
 */
//left의 모든 원소는 right의 모든 원소보다 작거나 같아야 한다
var partitionDisjoint = function (nums) {
  const n = nums.length;
  const rightMin = Array(n).fill(0);
  rightMin[n - 1] = nums[n - 1];
  for (let i = n - 2; i >= 0; i--) {
    rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
  }
  let leftMax = nums[0];
  let idx = 0;
  for (idx; idx < n - 1; idx++) {
    leftMax = Math.max(leftMax, nums[idx]);
    //left의 모든 요소가 right보다 작아야 함
    //left에서 가장 큰 값 <= right에서 가장 작은 값
    if (leftMax <= rightMin[idx + 1]) {
      break;
    }
  }
  return idx + 1;
};
