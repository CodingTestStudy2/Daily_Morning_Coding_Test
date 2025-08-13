/**
 * @param {number[]} nums
 * @return {number}
 */

// (1, 2, 1)
// (1), (1,2), (1,2,1), (2), (2,1), (1)
// 1개,   1개,     2개  , 1개  , 2개 , 1개
var sumCounts = function (nums) {
  const n = nums.length;
  let total = 0;
  for (let i = 0; i < n; i++) {
    //부분집합
    const sub = new Set();
    for (let j = i; j < n; j++) {
      let x = nums[j]; //부분 집합 내에 최초로 나온 값
      if (!sub.has(x)) sub.add(x);
      total += sub.size ** 2;
    }
  }
  return total;
};
