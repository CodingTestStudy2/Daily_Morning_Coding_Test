function alternatingSubarray(nums: number[]): number {
  let answer = -1;
  for (let i = 0; i < nums.length - 1; i++) {
    let mode = "minus"
    let curr = nums[i];
    let sub = [curr]
    for (let j = i + 1; j < nums.length; j++) {
      const next = nums[j];

      if (mode === "minus") {
        if (next - curr === 1) {
          curr = next;
          mode = "plus"
          sub.push(next)
        } else {
          break;
        }
      } else if (mode === "plus") {
        if (next - curr === -1) {
          curr = next;
          mode = "minus"
          sub.push(next)
        } else {
          break;
        }
      }
    }

    if (sub.length > 1) {
      answer = Math.max(answer, sub.length)
    }
  }

  return answer
};