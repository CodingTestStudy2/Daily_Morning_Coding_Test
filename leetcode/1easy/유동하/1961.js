/**
 * @param {string} s
 * @param {string[]} words
 * @return {boolean}
 */
var isPrefixString = function (s, words) {
  let result = "";
  for (const word of words) {
    result += word;
    if (result === s) return true;
  }

  return false;
};
