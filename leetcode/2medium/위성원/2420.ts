function goodIndices(nums: number[], k: number): number[] {
  const answer: number[] = [];
  for (let i = 0; i < nums.length; i++) {
    if (i - k < 0 || i + k + 1 > nums.length) {
      continue;
    }

    let isGood = true;
    // check is non-increasing

    let j = i - k;
    let max = Infinity;
    while (j < i) {
      const curr = nums[j];
      if (curr > max) {
        isGood = false;
        break;
      }

      max = curr;
      j++;
    }

    if (!isGood) {
      continue;
    }

    // check is decreasing
    j = i + 1;
    let min = -1;
    while (j < i + 1 + k) {
      const curr = nums[j];
      if (min > curr) {
        isGood = false;
      }

      min = curr;
      j++;
    }

    if (isGood) {
      answer.push(i)
    }
  }



  return answer
};