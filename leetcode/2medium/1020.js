/**
 * @param {number[][]} grid
 * @return {number}
 */
var numEnclaves = function (grid) {
  const rows = grid.length;
  const cols = grid[0].length;
  const dfs = (row, col) => {
    if (
      row < 0 ||
      col < 0 ||
      row >= rows ||
      col >= cols ||
      grid[row][col] === 0
    )
      return;
    grid[row][col] = 0;
    dfs(row - 1, col);
    dfs(row + 1, col);
    dfs(row, col - 1);
    dfs(row, col + 1);
  };
  for (let i = 0; i < rows; i++) {
    if (grid[i][0] === 1) dfs(i, 0);
    if (grid[i][cols - 1] === 1) dfs(i, cols - 1);
  }
  for (let j = 0; j < cols; j++) {
    if (grid[0][j] === 1) dfs(0, j);
    if (grid[rows - 1][j] === 1) dfs(rows - 1, j);
  }

  let count = 0;
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (grid[i][j] === 1) count++;
    }
  }
  return count;
};
