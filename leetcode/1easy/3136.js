/**
 * @param {string} word
 * @return {boolean}
 */
var isValid = function (word) {
  if (
    word.length >= 3 &&
    !/\W/.test(word) && //숫자, 특수문자, 공백이 아닌 문자
    /[aeiouAEIOU]/.test(word) &&
    /[b-df-hj-np-tv-zB-DF-HJ-NP-TV-Z]/.test(word)
  )
    return true;
  return false;
};
