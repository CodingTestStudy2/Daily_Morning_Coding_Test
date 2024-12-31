/**
 * @param {number} n
 * @return {number}
 */
var countHousePlacements = function (n) {
  var cache = new Map();

  var nthFib = (num) => {
    if (num <= 1) return BigInt(2);
    if (num === 2) return BigInt(3);
    if (cache.has(num)) return cache.get(num);

    cache.set(num, BigInt(nthFib(num - 1)) + BigInt(nthFib(num - 2)));
    return cache.get(num);
  };

  var oneSide = nthFib(n);
  return Number((oneSide * oneSide) % BigInt(Math.pow(10, 9) + 7));
};
