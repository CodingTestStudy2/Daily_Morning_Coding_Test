/**
 * @param {string} word
 * @return {boolean}
 */

var isValid = function (word) {
  if (word.length < 3) {
    return false;
  }

  const pattern2 = /^[A-Za-z0-9]+$/;

  if (!pattern2.test(word)) {
    return false;
  }

  const vowel = ["a", "e", "i", "o", "u"];
  const wordArr = word.toLowerCase().split("");
  const filteredVowelArr = wordArr.filter((w) => !vowel.includes(w));

  if (wordArr.length === filteredVowelArr.length) {
    return false;
  }

  const pattern4 = /[A-Za-z]/;
  const filteredVowelStr = filteredVowelArr.join("");

  if (!pattern4.test(filteredVowelStr)) {
    return false;
  }

  return true;
};
