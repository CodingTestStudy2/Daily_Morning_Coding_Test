/**
 * @param {number[]} count
 * @return {number[]}
 */
var sampleStats = function (count) {
  let maxCountSample = { index: 0, count: 0 };
  let minIndex = Infinity;
  let maxIndex = 0;
  let sampleCount = 0;
  let sampleSum = 0;
  count.forEach((c, index) => {
    if (c > 0) {
      sampleCount += c;
      sampleSum += index * c;
      if (minIndex > index) {
        minIndex = index;
      }

      if (index > maxIndex) {
        maxIndex = index;
      }

      if (c > maxCountSample.count) {
        maxCountSample = {
          index,
          count: c,
        };
      }
    }
  });

  const min = minIndex.toFixed(5);
  const max = maxIndex.toFixed(5);
  const mean = (sampleSum / sampleCount).toFixed(5);
  const median = 0; // median 구하는중...
  const mode = maxCountSample.index.toFixed(5);

  return [Number(min), Number(max), Number(mean), Number(median), Number(mode)];
};
