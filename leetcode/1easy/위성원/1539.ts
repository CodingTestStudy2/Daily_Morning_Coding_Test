function findKthPositive(arr: number[], k: number): number {

  let count = 0;
  let pointer = 0;
  for (let i = 0; i < 10000; i++) {
    const curr = i + 1;

    if (curr !== arr[pointer]) {
      count++;
    } else {
      pointer++;
    }

    if (count === k) {
      return curr;
    }
  }

  return -1
};