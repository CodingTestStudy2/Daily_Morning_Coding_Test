function canMeasureWater(x: number, y: number, target: number): boolean {
  let flag = false
  const visited = {}
  const dfs = (amountX, amountY) => {
    if (amountX + amountY === target) {
      flag = true;
      return;
    }

    if (visited[`${amountX}${amountY}`]) {
      return
    }

    visited[`${amountX}${amountY}`] = true;

    if (amountX !== x) {
      // fill x
      dfs(x, amountY)
    }

    if (amountY !== y) {
      // fill y
      dfs(amountX, y)
    }

    if (amountX !== 0) {
      // Empty x
      dfs(0, amountY)
    }

    if (amountY !== 0) {
      // Empty y
      dfs(amountX, 0)
    }

    // Pour water from x to y
    const leftY = y - amountY;
    const leftX = leftY - amountX > 0 ? 0 : amountX - leftY;
    dfs(leftX, Math.min(amountY + amountX, y))

    // Pour water from y to x
    const leftX2 = x - amountX;
    const leftY2 = leftX2 - amountY > 0 ? 0 : amountY - leftX2;
    dfs(Math.min(amountX + amountY, x), leftY2)
  }

  dfs(0, 0)

  return flag
};