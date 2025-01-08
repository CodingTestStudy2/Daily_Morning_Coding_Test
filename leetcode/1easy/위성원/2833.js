/**
 * @param {string} moves
 * @return {number}
 */
var furthestDistanceFromOrigin = function (moves) {
  let lCount = 0;
  let rCount = 0;
  let underCount = 0;
  for (let i = 0; i < moves.length; i++) {
    const move = moves[i];
    if (move === "L") lCount++;
    if (move === "R") rCount++;
    if (move === "_") underCount++;
  }

  return Math.abs(lCount - rCount) + underCount;
};
