function isSubstringPresent(s: string): boolean {
  const subs: string[] = [];
  for (let i = 0; i < s.length - 1; i++) {
    const sub = s.slice(i, i + 2);
    subs.push(sub)
  }

  const rS = s.split('').reverse().join('')

  for (let i = 0; i < s.length - 1; i++) {
    const sub = rS.slice(i, i + 2);
    if (subs.includes(sub)) {
      return true
    }
  }

  return false
};