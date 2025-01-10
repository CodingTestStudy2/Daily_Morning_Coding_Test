/**
 * @param {string} s
 * @param {string[]} dictionary
 * @return {number}
 */
var minExtraChar = function (s, dictionary) {
  const counts = [];
  let ans = Infinity;
  const minLenOfWord = dictionary.reduce((prev, curr) => {
    if (prev.length > curr.length) {
      return curr;
    }

    return prev;
  }).length;

  const dfs = (word) => {
    for (let i = 0; i < word.length; i++) {
      const sliced = word.slice(i, minLenOfWord);
    }
  };

  return ans;
};
