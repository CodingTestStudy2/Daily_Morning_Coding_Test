/**
 * @param {number} n
 * @param {number} minProfit
 * @param {number[]} group
 * @param {number[]} profit
 * @return {number}
 */
var profitableSchemes = function (n, minProfit, group, profit) {
  let answer = 0;
  const subset = (startI, countSum, profitSum) => {
    if (countSum > n) {
      return
    }

    if (profitSum >= minProfit) {
      answer++;
    }

    for (let i = startI; i < group.length; i++) {
      const count = group[i];
      subset(i + 1, countSum + count, profitSum + profit[i])
    }
  }

  subset(0, 0, 0)

  return answer % 1000000007
};