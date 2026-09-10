/**
 * @param {number} length
 * @param {number} width
 * @param {number} height
 * @param {number} mass
 * @return {string}
 */
var categorizeBox = function (length, width, height, mass) {
  const bulky =
    length >= 10000 ||
    width >= 10000 ||
    height >= 10000 ||
    length * width * height >= Math.pow(10, 9);
  const heavy = mass >= 100;

  if (bulky) {
    if (heavy) return "Both";
    else return "Bulky";
  } else {
    if (heavy) return "Heavy";
    else return "Neither";
  }
};
