function gcdOfStrings(str1: string, str2: string): string {
  let min = str1.length >= str2.length ? str2 : str1;
  let max = str1.length >= str2.length ? str1 : str2;

  let answer = ""
  for (let i = 1; i <= min.length; i++) {
    const split = min.slice(0, i)
    const arr = min.split(split)
    const arr2 = max.split(split)

    if (arr.every((char) => char === "") && arr2.every((char) => char === "")) {
      answer = split
    }
  }

  return answer
};