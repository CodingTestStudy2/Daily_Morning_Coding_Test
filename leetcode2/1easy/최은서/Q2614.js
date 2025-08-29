/**
 * @param {number[][]} nums
 * @return {number}
 */
var diagonalPrime = function (nums) {
  function isPrime(n) {
    //1 <= nums[i][j] <= 4*106
    if (n === 1) return false;
    for (let i = 2; i * i <= n; i++) {
      if (n % i === 0) return false;
    }
    return true;
  }
  let res = 0;
  //풀이 : 주대각선, 부대각선에서 소수를 찾고 최대값 갱신
  //시간 복잡도 : O(n * n)
  for (let i = 0; i < nums.length; i++) {
    if (isPrime(nums[i][i])) res = Math.max(res, nums[i][i]); //주대각선
    if (isPrime(nums[nums.length - 1 - i][i]))
      res = Math.max(res, nums[nums.length - 1 - i][i]); //부대각선
  }
  return res;
};
