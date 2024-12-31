var countHousePlacements = function (n) {
  const MOD = BigInt(1e9 + 7);
  let prev2 = BigInt(1);
  let prev1 = BigInt(2);

  for (let i = 2; i <= n; i++) {
    const curr = (prev1 + prev2) % MOD;
    prev2 = prev1;
    prev1 = curr;
  }

  return Number((prev1 * prev1) % MOD);
};
