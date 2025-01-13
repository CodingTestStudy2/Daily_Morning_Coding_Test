/**
 * @param {number} num
 * @return {number}
 */
var maxDiff = function (num) {
  let a = num.toString().split("");
  let b = num.toString().split("");

  for (let i = 0; i < a.length; i++) {
    if (a[i] === "9") continue;

    const pivot = a[i];
    a = a.map((n) => (n === pivot ? "9" : n));
    break;
  }

  for (let i = 0; i < b.length; i++) {
    if (b[i] === "0") continue;
    if (b[0] === "1" && b[i] === "1") continue;

    const pivot = b[i];
    if (i === 0) {
      b = b.map((n) => (n === pivot ? "1" : n));
      break;
    } else {
      b = b.map((n) => (n === pivot ? "0" : n));
      break;
    }
  }

  return Number(a.join("")) - Number(b.join(""));
};
