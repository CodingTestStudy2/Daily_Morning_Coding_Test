/**
 * @param {number[]} jobs
 * @param {number} k
 * @return {number}
 */
var minimumTimeRequired = function (jobs, k) {
  if (jobs.length === k) return k;
  else {
    let sum = 0;
    jobs.sort((a, b) => a - b);
    jobs.forEach((i) => {
      sum += i;
    });
    //배열을 어떻게 나눠서 비교할 수 있을까..
  }
};
