function maxRepeating(sequence: string, word: string): number {
  let answer = 0;
  let newWord = word;

  while (sequence.includes(newWord)) {
    answer++;
    newWord += word;
  }

  return answer
};