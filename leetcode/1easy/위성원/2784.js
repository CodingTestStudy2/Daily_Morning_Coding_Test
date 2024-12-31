/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isGood = function (nums) {
  // nums의 최대값 n 구하기
  const n = Math.max(...nums);
  // n으로 순열 만들고 nums가 그 순열인지 판단하기
  // 길이 판단
  // nums의 길이는 n + 1이어야 한다.
  if (nums.length !== n + 1) {
    return false;
  }
  // nums는 n이 두번 나오는 순열이어야 한다.
  const visitedCounts = [];
  for (const num of nums) {
    const count = visitedCounts[num];
    // 이미 중복된 숫자가 있는 경우
    if (num === n) {
      if (count === 2) {
        return false;
      }
    } else if (count === 1) {
      return false;
    }

    visitedCounts[num] = !count ? 1 : count + 1;
  }

  // 숫자중에 빠진 경우
  for (let i = 1; i <= n; i++) {
    const count = visitedCounts[i];
    if (i === n) {
      if (count !== 2) {
        return false;
      }
    } else if (count !== 1) {
      return false;
    }
  }

  return true;
};
