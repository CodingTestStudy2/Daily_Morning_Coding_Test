/**
 * @param {number[]} nums
 * @return {number[]}
 */
var getSneakyNumbers = function (nums) {
  const result = [];
  const map = new Map();

  for (const num of nums) {
    if (map.has(num)) {
      result.push(num);
      if (result.length === 2) break;
    } else {
      map.set(num, num);
    }
  }

  return result;
};
