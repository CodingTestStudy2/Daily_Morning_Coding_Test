var accountBalanceAfterPurchase = function (purchaseAmount) {
  const money =
    Math.ceil(purchaseAmount % 10) < 5
      ? Math.round(purchaseAmount / 10) * 10
      : Math.ceil(purchaseAmount / 10) * 10;
  const rest = 100 - money;
  return rest;
};
