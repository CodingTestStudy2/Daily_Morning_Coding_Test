/**
 * @param {number} n
 * @return {number}
 */
//n = 1 -> 쪼개지 않음
//n = 2의 배수 -> 전체를 가로질러 잘라나감
//n != 2의 배수 -> 원점 기준으로 잘라나감
var numberOfCuts = function (n) {
  // 1 <= n <= 100
  if (n === 1) return 0;
  return n % 2 === 0 ? n / 2 : n;
};
