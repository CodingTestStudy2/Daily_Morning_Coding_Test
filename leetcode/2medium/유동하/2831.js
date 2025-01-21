/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var longestEqualSubarray = function (nums, k) {
  const count = new Map();
  let left = 0;
  let result = 0;
  let freq = 0;

  for (let right = 0; right < nums.length; right++) {
    count.set(nums[right], (count.get(nums[right]) || 0) + 1);
    freq = Math.max(freq, count.get(nums[right]));

    while (right - left + 1 - freq > k) {
      count.set(nums[left], count.get(nums[left]) - 1);
      left++;
    }

    result = Math.max(result, freq);
  }

  return result;
};
