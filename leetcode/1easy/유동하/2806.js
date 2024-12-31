/**
 * @param {number} purchaseAmount
 * @return {number}
 */
var accountBalanceAfterPurchase = function (purchaseAmount) {
  const value = Math.floor((purchaseAmount + 5) / 10) * 10;
  return 100 - value;
};
