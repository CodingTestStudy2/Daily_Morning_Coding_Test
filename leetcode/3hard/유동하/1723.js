/**
 * @param {number[]} jobs
 * @param {number} k
 * @return {number}
 */
var minimumTimeRequired = function (jobs, k) {
  let result = Number.MAX_SAFE_INTEGER;
  const workTime = Array(k).fill(0);

  const foo = (idx) => {
    if (idx === jobs.length) {
      result = Math.min(result, Math.max(...workTime));
      return;
    }

    for (let i = 0; i < k; i++) {
      if (workTime[i] + jobs[idx] >= result) continue;
      workTime[i] += jobs[idx];
      foo(idx + 1);
      workTime[i] -= jobs[idx];
      if (workTime[i] === 0) break;
    }
  };

  foo(0);

  return result;
};
