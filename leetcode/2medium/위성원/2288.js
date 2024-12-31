/**
 * @param {string} sentence
 * @param {number} discount
 * @return {string}
 */
var discountPrices = function (sentence, discount) {
  // price를 찾고 ($sign 뒤 숫자들)
  const regex = /(?<=(\s|^))\$(\d+)(?=(\s|$))/g;
  const newSentence = sentence.replace(regex, (e) => {
    const num = Number(e.slice(1));
    const discountedNum = (num * ((100 - discount) / 100)).toFixed(2);
    return `$${discountedNum}`;
  });
  // discount 적용한 뒤 replace 하기

  return newSentence;
};
