function maxProfit(prices: number[]): number {
  const arr = prices
    .map((p, index) => ({
      p,
      index,
    }))
    .sort((a, b) => {
      if (a.p === b.p) {
        return a.index - b.index;
      }

      return a.p - b.p;
    });

  let max = 0;
  for (let i = 0; i < arr.length; i++) {
    const v = arr[i];
    for (let j = arr.length - 1; j > i; j--) {
      const vj = arr[j];
      if (max > vj.p - v.p) {
        break;
      }

      if (vj.index > v.index) {
        max = vj.p - v.p;
      }
    }
  }

  return max;
}
