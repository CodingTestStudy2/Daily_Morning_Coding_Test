function numberOfSpecialChars(word) {
  const lowerSet = new Set();
  const upperSet = new Set();

  for (const char of word) {
    if (char >= "a" && char <= "z") {
      lowerSet.add(char);
    } else if (char >= "A" && char <= "Z") {
      upperSet.add(char);
    }
  }

  let specialCount = 0;
  for (const char of lowerSet) {
    if (upperSet.has(char.toUpperCase())) {
      specialCount++;
    }
  }

  return specialCount;
}
