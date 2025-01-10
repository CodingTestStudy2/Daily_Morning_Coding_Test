function isToeplitzMatrix(matrix) {
  const isSame = (x, y, el) => {
    let same = true;
    let nx = x + 1;
    let ny = y + 1;
    while (nx < matrix.length && ny < matrix[0].length) {
      const nEl = matrix[nx][ny];

      if (el !== nEl) {
        return false;
      }

      nx += 1;
      ny += 1;
    }

    return same;
  };

  // from left bottom to top
  for (let i = matrix.length - 1; i >= 0; i--) {
    const el = matrix[i][0];
    if (!isSame(i, 0, el)) {
      return false;
    }
  }

  // from top left to right
  for (let i = 1; i < matrix[0].length; i++) {
    const el = matrix[0][i];
    if (!isSame(0, i, el)) {
      return false;
    }
  }

  return true;
}
