/**
 * @param {number} num
 * @return {number}
 */
var maxDiff = function (num) {
  const firstNum = num

  // num의 자리 수 찾기
  let lenOfNum = 0;
  let temp = num;
  while (temp > 0) {
    lenOfNum++;
    temp = Math.floor(temp / 10)
  }

  let len = lenOfNum;
  let x2 = 0
  let y2 = 1;
  // x, y 찾기 (작은)
  while (len > 0) {
    const multi = 10 ** (len - 1);
    const num2 = Math.floor(num / multi) % 10;
    if (len !== lenOfNum && num2 !== 0) {
      x2 = num2;
      y2 = 0;
      break;
    }

    if (num2 !== 0 && num2 !== 1) {
      x2 = num2;
      break;
    }
    len--;
  }

  // x, y 찾기 (큰)
  let x = 9;
  len = lenOfNum;
  while (len > 0) {
    const multi = 10 ** (len - 1);
    const num2 = Math.floor(num / multi) % 10;
    if (num2 !== 9) {
      x = num2;
      break;
    }

    len--;
  }

  // 첫번째 숫자와 같은 숫자 9, 1로 바꾸기
  // 이미 9, 1 이라면? 그 다음 숫자를 9로 바꾸어야 함
  let a = 0;
  let b = 0;
  let i = 0;
  let newNum = num;

  while (newNum > 0) {
    const multiple = (10 ** i) ?? 1;
    const curr = newNum % 10;

    if (curr === x) {
      a += multiple * 9;
    } else {
      a += multiple * curr
    }

    newNum = Math.floor(newNum / 10)
    i++;
  }

  newNum = num;
  i = 0;
  while (newNum > 0) {
    const multiple = (10 ** i) ?? 1;
    const curr = newNum % 10;

    if (curr === x2) {
      b += multiple * y2;
    } else {
      b += multiple * curr
    }

    newNum = Math.floor(newNum / 10)
    i++;
  }

  return a - b
};