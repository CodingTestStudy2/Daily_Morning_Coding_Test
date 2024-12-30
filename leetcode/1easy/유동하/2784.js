/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isGood = function (nums) {
  nums.sort((a, b) => a - b);
  let target = 1;
  let result = true;

  for (let i = 0; i < nums.length - 1; i++) {
    if (target === nums[i]) {
      target++;
    } else {
      result = false;
      break;
    }
  }

  if (nums.at(-1) !== nums.at(-2)) {
    result = false;
  }

  return result;
};
