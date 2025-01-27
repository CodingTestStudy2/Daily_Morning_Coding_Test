function countVowelSubstrings(word: string): number {
  let answer = 0;
  const vowels = ["a", "e", "i", "o", "u"];
  for (let i = 0; i < word.length; i++) {
    const char = word[i];

    if (vowels.includes(char)) {
      let vowelsCount = 1;
      const vowelsVisited: (undefined | boolean)[] = [];
      vowelsVisited[char.charCodeAt(0)] = true;
      let j = i + 1;
      while (j < word.length) {
        const nChar = word[j];
        if (vowels.includes(nChar)) {
          vowelsCount++;
          vowelsVisited[nChar.charCodeAt(0)] = true;
        } else {
          break;
        }

        if (vowelsCount >= 5) {
          if (vowels.every((v) => {
            return vowelsVisited[v.charCodeAt(0)]
          })) {
            answer++
          }
        }
        j++;
      }
    }
  }

  return answer
};