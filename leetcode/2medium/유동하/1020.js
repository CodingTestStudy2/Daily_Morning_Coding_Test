/**
 * @param {number[][]} grid
 * @return {number}
 */
var numEnclaves = function (grid) {
  const n = grid.length;
  const m = grid[0].length;
  const visit = Array.from({ length: n }, () => Array(m).fill(false));
  const dx = [0, 1, 0, -1];
  const dy = [1, 0, -1, 0];
  const queue = [];
  let result = 0;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (grid[i][j] === 0) continue;
      let flag = true;
      let count = 0;

      queue.push([i, j]);

      while (queue.length) {
        const [x, y] = queue.shift();

        if (
          x < 0 ||
          x >= n ||
          y < 0 ||
          y >= m ||
          visit[x][y] ||
          grid[x][y] === 0
        )
          continue;
        if (x === 0 || x === n - 1 || y === 0 || y === m - 1) {
          flag = false;
        }

        visit[x][y] = true;
        count++;

        for (let i = 0; i < 4; i++) {
          const nx = dx[i] + x;
          const ny = dy[i] + y;

          queue.push([nx, ny]);
        }
      }

      if (flag) {
        result += count;
      }
    }
  }

  return result;
};
