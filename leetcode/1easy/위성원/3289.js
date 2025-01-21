/**
 * @param {number[]} nums
 * @return {number[]}
 */
var getSneakyNumbers = function (nums) {
  const counts = new Array(103).fill(0);
  const answer = []
  nums.forEach((num) => {
    const count = counts[num];

    if (count > 0) {
      answer.push(num)
    }

    counts[num] = count + 1;
  })

  return answer
};