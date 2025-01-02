/**
 * @param {number[][]} grid
 * @return {number}
 */
var numEnclaves = function (grid) {
  const [m, n] = [grid.length, grid[0].length];
  const xDirs = [0, 0, -1, 1];
  const yDirs = [-1, 1, 0, 0];
  const dfs = (i, j) => {
    grid[i][j] = 0;
    for (let k = 0; k < 4; k++) {
      const x = i + xDirs[k];
      const y = j + yDirs[k];
      if (x >= 0 && x < m && y >= 0 && y <= n && grid[x][y] === 1) {
        dfs(x, y);
      }
    }
  };
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      // 바운더리에 있는 1만 탐색
      if (
        grid[i][j] === 1 &&
        (i === 0 || i === m - 1 || j === 0 || j === n - 1)
      ) {
        console.log(i, j);
        dfs(i, j);
      }
    }
  }

  let ans = 0;
  console.log(grid);
  for (const row of grid) {
    for (const v of row) {
      ans += v;
    }
  }
  return ans;
};
