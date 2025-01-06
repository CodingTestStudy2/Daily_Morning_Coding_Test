/**
 * @param {number[][]} ranges
 * @param {number} left
 * @param {number} right
 * @return {boolean}
 */
var isCovered = function (ranges, left, right) {
  for (let i = left; i <= right; i++) {
    let flag = false;
    for (const range of ranges) {
      const [min, max] = range;

      if (i >= min && i <= max) {
        flag = true;
        break;
      }
    }

    if (!flag) return false;
  }

  return true;
};
