function findChampion(grid: number[][]) {
  const go = (index: number) => {
    for (let i = 0; i < grid.length; i++) {
      if (grid[i][index] === 1) {
        return go(i)
      }
    }

    return index;
  }

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[0].length; j++) {
      if (grid[i][j] === 1) {
        return go(i)
      }
    }
  }
};