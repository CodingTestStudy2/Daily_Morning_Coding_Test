const isPrefixString = function (s, words) {
  let concatenated = "";

  for (let word of words) {
    concatenated += word;
    if (concatenated === s) {
      return true;
    }
    if (concatenated.length > s.length) {
      return false;
    }
  }

  return false;
};
