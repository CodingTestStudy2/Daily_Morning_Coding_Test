/**
 * @param {number[][]} tiles
 * @param {number} carpetLen
 * @return {number}
 */
var maximumWhiteTiles = function (tiles, carpetLen) {
  tiles.sort((a, b) => {
    return a[0] - b[0]
  })

  let maxLength = 0;
  let prevTile = tiles[0]

  for (let i = 1; i < tiles.length; i++) {
    const tile = tiles[i]
    const [l, r] = tile;
    const [prevL, prevR] = prevTile;

    if (l - prevR === 1) {
      const gap = r - prevL;
      if (gap > maxLength) {
        maxLength = gap;
      }

      prevTile = [prevL, r];
    } else {
      const gap = r - l;
      if (gap > maxLength) {
        maxLength = gap;
      }

      prevTile = tile;
    }
  }

  maxLength++
  return maxLength > carpetLen ? carpetLen : maxLength
};