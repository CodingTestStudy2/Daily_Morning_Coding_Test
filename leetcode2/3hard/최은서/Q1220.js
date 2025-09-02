/**
 * @param {number} n
 * @return {number}
 */
var countVowelPermutation = function (n) {
  const dp = Array.from({ length: n + 1 }, () => Array(5).fill(0));
  if (n === 1) return 5;
  const MOD = 1000000007;
  for (let i = 0; i < 5; i++) {
    dp[1][i] = 1;
  }
  for (let i = 2; i < n + 1; i++) {
    dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % MOD; //u,i,e 뒤 -> a로 끝남
    dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD; //a, i가 뒤 -> e로 끝남
    dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % MOD; //e, o가 뒤 -> i로 끝남
    dp[i][3] = dp[i - 1][2] % MOD; //i가 뒤 -> o로 끝남
    dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % MOD; //i, o가 뒤 -> u로 끝남
  }
  return dp[n].reduce((cur, acc) => acc + cur, 0) % MOD;
};
