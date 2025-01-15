/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSumMinProduct = function (nums) {
  let answer = 0;

  for (let i = 0; i < nums.length; i++) {
    let min = Infinity;
    let sum = 0;
    for (let j = i; j < nums.length; j++) {
      const second = nums[j];
      sum += second;

      min = min > second ? second : min

      if (sum * min > answer) {
        answer = sum * min;
      }
    }
  }

  return answer % 1000000007
};