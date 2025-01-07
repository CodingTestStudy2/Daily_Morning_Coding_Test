/**
 * @param {string} word
 * @return {boolean}
 */

const consonantList = [
  "B",
  "C",
  "D",
  "F",
  "G",
  "H",
  "J",
  "K",
  "L",
  "M",
  "N",
  "P",
  "Q",
  "R",
  "S",
  "T",
  "V",
  "W",
  "X",
  "Y",
  "Z",
];
const vowelList = ["A", "E", "I", "O", "U"];
const numsList = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"];

var isValid = function (word) {
  if (word.length < 3) return false;
  let isVovel = false,
    isConsonant = false;
  word = word.toUpperCase();

  for (i = 0; i < word.length; i++) {
    if (vowelList.includes(word[i])) {
      isVovel = true;
    } else if (consonantList.includes(word[i])) {
      isConsonant = true;
    } else if (!numsList.includes(word[i])) {
      return false;
    }
  }
  return isVovel && isConsonant;
};
