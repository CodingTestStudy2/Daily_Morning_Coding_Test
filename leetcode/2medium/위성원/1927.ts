function sumGame(num: string) {
  const len = num.length;

  const getSum = (digit: string) => {
    let sum = 0;
    for (const d of digit) {
      if (d === "?") {
        continue;
      }

      sum += Number(d);
    }

    return sum;
  };

  const firstHalf = num.slice(0, len / 2);
  const secondHalf = num.slice(len / 2, len);

  if (!num.includes("?")) {
    const firstHalfSum = getSum(firstHalf);
    const secondHalfSum = getSum(secondHalf);

    return firstHalfSum !== secondHalfSum ? true : false;
  }
}
