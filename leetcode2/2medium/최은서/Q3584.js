/**
 * @param {number[]} nums
 * @param {number} m
 * @return {number}
 */
//subsequence m : 연속하는 m 개의 숫자가 아님 -> 길이가 m인 배열을 보장하고 시작과 끝만 알면 됨
//nums.length가 10^5 => 한 번만 순회 -> O(N)
//(1) i를 끝점으로 두고, 앞에 나온 시작점 후보들 중에서 가장 큰 값과 가장 작은 값을 저장
//(2) 끝점이 양수일 때에는 가장 큰 수와 곱하는게 최대. 끝점이 음수일 때는 가장 작은 수와 곱하는게 최대
var maximumProduct = function (nums, m) {
  let minNumber = Infinity;
  let maxNumber = -Infinity;
  let res = -Infinity;
  for (let i = 0; i < nums.length; i++) {
    //끝점-시작점+1 = m -> 시작점 = 끝점 + 1 - m
    const start = i + 1 - m;
    if (start >= 0) {
      //시작점이 유효한 경우
      maxNumber = Math.max(maxNumber, nums[start]);
      minNumber = Math.min(minNumber, nums[start]);
    }
    if (i >= m - 1) {
      //끝점
      if (nums[i] > 0) res = Math.max(res, nums[i] * maxNumber);
      if (nums[i] <= 0) res = Math.max(res, nums[i] * minNumber);
    }
  }
  return res;
};
