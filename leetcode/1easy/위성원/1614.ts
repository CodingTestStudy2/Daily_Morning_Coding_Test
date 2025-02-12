function maxDepth(s: string): number {
  const stack: string[] = [];

  let depth = 0;
  let max = 0;
  for (const char of s) {
    if (char === "(") {
      depth++;
      stack.push(char);
    } else if (char === ")") {
      max = Math.max(max, depth);
      stack.pop();
      depth--;
    }
  }

  return max;
}
