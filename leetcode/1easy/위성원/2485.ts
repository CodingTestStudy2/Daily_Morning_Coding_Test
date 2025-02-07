function pivotInteger(n: number): number {
  if (n === 1) {
    return 1;
  }

  let middle = Math.floor(n / 2)
  let leftSum;
  let rightSum;

  for (let i = 1; i <= middle; i++) {
    leftSum += i;
  }

  for (let i = middle + 1; i <= n; i++) {
    rightSum += i;
  }

  console.log(leftSum, rightSum)


  return middle
};