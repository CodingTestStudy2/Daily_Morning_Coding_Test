/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves2 = function (nums) {
  nums.sort((a, b) => a - b);
  const medium = nums[Math.floor(nums.length / 2)];
  let count = 0;
  for (let num of nums) {
    count += Math.abs(num - medium);
  }
  return count;
};

//처음에 그냥 평균 구해서 편차 구했는데 그렇게 하니 최적해를 구하지 못하는 경우가 있었다.
//절대값 거리의 최소합은 중앙값에서 발생하기 때문에 평균은 절대값 거리의 최소합을 보장하지 못했다.
//정렬된 배열의 중간 값인 중앙값을 사용하여 계산했다.
