/**
 * @param {number} n
 * @return {number}
 */
var countHousePlacements = function (n) {
  const MOD = 1000000007n;
  const arr = [0, 2n, 3n, 5n, 8n];

  for (let i = 5; i <= n; i++) {
    arr[i] = (arr[i - 1] + arr[i - 2]) % MOD;
  }

  return Number((arr[n] * arr[n]) % MOD);
};
