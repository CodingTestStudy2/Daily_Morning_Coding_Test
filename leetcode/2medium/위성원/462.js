/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves2 = function (nums) {
  let answer = Infinity;
  for (let i = 0; i < nums.length; i++) {
    const num = nums[i];
    let count = 0;
    for (let j = 0; j < nums.length; j++) {
      if (j === i) {
        continue;
      }

      const num2 = nums[j];
      count += Math.abs(num - num2);
    }

    if (answer > count) {
      answer = count;
    }
  }

  return answer;
};
