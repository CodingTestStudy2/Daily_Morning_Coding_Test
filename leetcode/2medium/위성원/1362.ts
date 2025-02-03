function closestDivisors(num: number): number[] {
  const num1 = num + 1;
  const num2 = num + 2;

  let min = Infinity;
  let answer: number[] = [];

  let i = 1;
  let j = num1;
  while (Math.sqrt(j) >= i) {
    if (num1 % i === 0) {
      const d = num1 / i;
      if (min > Math.abs(d - i)) {
        min = Math.abs(d - i);
        answer = [d, i];
      }
    }
    i++;
  }

  i = 1;
  j = num2;
  while (Math.sqrt(j) >= i) {
    if (num2 % i === 0) {
      const d = num2 / i;
      if (min > Math.abs(d - i)) {
        min = Math.abs(d - i);
        answer = [d, i];
      }
    }
    i++;
  }

  return answer;
}
