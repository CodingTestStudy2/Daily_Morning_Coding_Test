/**
 * @param {number[]} count
 * @return {number[]}
 */
var sampleStats = function (count) {
  let min = Number.MAX_SAFE_INTEGER;
  let max = Number.MIN_SAFE_INTEGER;

  for (let i = 0; i < count.length; i++) {
    if (count[i] !== 0) {
      min = Math.min(i, min);
      max = Math.max(i, max);
    }
  }

  let sum = 0;
  const totalCnt = count.reduce((acc, cur) => acc + cur);

  for (let i = 0; i < count.length; i++) {
    sum += count[i] * i;
  }

  const mean = sum / totalCnt;

  const mode = count.indexOf(Math.max(...count));

  let median;
  let count_sum = 0;
  const mid = totalCnt / 2;

  if (totalCnt % 2 === 0) {
    let first = null;
    for (let i = 0; i < count.length; i++) {
      count_sum += count[i];
      if (first === null && count_sum > mid - 1) {
        first = i;
      }
      if (count_sum > mid) {
        median = (first + i) / 2;
        break;
      }
    }
  } else {
    for (let i = 0; i < count.length; i++) {
      count_sum += count[i];
      if (count_sum > mid) {
        median = i;
        break;
      }
    }
  }

  return [min, max, mean, median, mode];
};
