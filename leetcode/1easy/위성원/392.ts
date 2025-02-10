function isSubsequence(s: string, t: string): boolean {
  if (s.length === 0) {
    return true;
  }

  if (t.length === 0) {
    return false;
  }

  let maxIndex = 0;
  for (let i = 0; i < s.length; i++) {
    const charS = s[i];
    let okay = false;
    for (let j = maxIndex; j < t.length; j++) {
      const charT = t[j];
      if (charS === charT) {
        okay = true;
        maxIndex = j + 1;
        break;
      }
    }

    if (!okay) {
      return false;
    }
  }

  return true;
}
