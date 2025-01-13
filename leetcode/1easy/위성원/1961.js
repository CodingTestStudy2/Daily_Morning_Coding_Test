/**
 * @param {string} s
 * @param {string[]} words
 * @return {boolean}
 */
var isPrefixString = function (s, words) {
  let concatS = "";
  for (const word of words) {
    concatS += word;

    if (concatS === s) {
      return true;
    }

    if (concatS.length >= s.length) {
      return false;
    }
  }

  return false;
};