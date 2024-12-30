/**
 * @param {string} sentence
 * @param {number} discount
 * @return {string}
 */
var discountPrices = function (sentence, discount) {
  const isPrice = (str) => {
    const regex = /^\$\d+$/;
    return regex.test(str);
  };

  const data = [];

  for (const word of sentence.split(" ")) {
    if (isPrice(word)) {
      const price = Number(word.slice(1));
      const result = (price * (1 - discount / 100)).toFixed(2);
      data.push("$" + result);
    } else {
      data.push(word);
    }
  }

  return data.join(" ");
};
