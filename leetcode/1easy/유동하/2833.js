/**
 * @param {string} moves
 * @return {number}
 */
var furthestDistanceFromOrigin = function (moves) {
  let l_count = 0;
  let r_count = 0;
  let bar_count = 0;

  for (const char of moves.split("")) {
    if (char === "L") l_count++;
    if (char === "R") r_count++;
    if (char === "_") bar_count++;
  }

  return Math.max(l_count, r_count) + bar_count - Math.min(l_count, r_count);
};
