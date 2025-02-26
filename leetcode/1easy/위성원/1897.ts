function makeEqual(words: string[]): boolean {
  if (words.length === 1) {
    return true
  }

  const len = words.reduce((prev, curr) => {
    return prev + curr.length
  }, 0)

  if (len % words.length !== 0) {
    return false
  }

  const al = new Array(26).fill(0);
  for (const word of words) {
    for (const c of word) {
      al[c.charCodeAt(0) - 97]++
    }
  }

  const good = al.every((n) => n % words.length === 0)

  return good
};