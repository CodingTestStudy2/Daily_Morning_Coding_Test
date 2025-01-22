/**
 * @param {string} s
 * @return {number}
 */
var secondsToRemoveOccurrences = function (s) {
  let seconds = 0;
  let isContinue = true;
  let newS = s;

  while (isContinue) {
    isContinue = false;
    let tempS = "";

    for (let i = 0; i < newS.length; i++) {
      const cur = newS[i];
      const next = newS[i + 1];

      if (cur === "0" && next === "1") {
        isContinue = true;
        tempS += `${next}${cur}`
        i++;
      } else {
        tempS += cur;
      }
    }

    newS = tempS

    if (isContinue) {
      seconds++;
    }
  }

  return seconds;
};
