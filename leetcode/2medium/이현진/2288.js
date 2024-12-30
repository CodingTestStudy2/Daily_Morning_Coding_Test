/**
 * @param {string} sentence
 * @param {number} discount
 * @return {string}
 */
var discountPrices = function (sentence, discount) {
  let sen = sentence.split(" ");
  for (let i = 0; i < sen.length; i++) {
    const condition = sen[i][0] === "$";
    const condition2 = parseFloat(sen[i].slice(1)) + "" === sen[i].slice(1);

    if (condition && condition2) {
      let number = (Number(sen[i].slice(1)) * (1 - discount / 100)).toFixed(2);
      sen[i] = "$" + number;
    }
  }
  return sen.join(" ");
};
