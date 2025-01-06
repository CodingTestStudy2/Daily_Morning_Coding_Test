/**
 * @param {number[][]} ranges
 * @param {number} left
 * @param {number} right
 * @return {boolean}
 */
var isCovered = function (ranges, left, right) {
  // left ~ right 사이의 숫자를
  // range들이 담고 있는지 확인

  for (let i = left; i <= right; i++) {
    const number = i;
    let okay = false;
    for (let j = 0; j < ranges.length; j++) {
      const range = ranges[j];
      const start = range[0];
      const end = range[1];
      // range 판단
      if (number >= start && number <= end) {
        okay = true;
        break;
      }
    }

    if (!okay) {
      return false;
    }
  }

  return true;
};
