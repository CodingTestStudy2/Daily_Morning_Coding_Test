/**
 * @param {number[]} nums
 * @param {number[]} numsDivide
 * @return {number}
 */
var minOperations = function (nums, numsDivide) {
  nums.sort((a, b) => a - b);
  var numsMin = Math.min(...nums);
  var available = false;
  for (let numD of numsDivide) {
    if (numD % numsMin !== 0) {
      available = false;
      break;
    } else {
      const idx = nums.indexOf(numsMin);
      var removed = nums.splice(idx, 1);
      console.log(removed);
      available = true;
    }
  }
  console.log(available);
  console.log(removed);
  return removed;
};
