function findMinimumTime(strength: number[], k: number): number {
  let x = 1;
  let time = 0;
  let energy = 0;
  let s = [...strength].sort((a, b) => b - a);

  while (s.length > 0) {

    time++;
    energy += x;

    for (let i = 0; i < s.length; i++) {
      if (energy >= s[i]) {
        energy = 0;
        x += k;
        s = [...s.slice(0, i), ...s.slice(i + 1, s.length)]
        break;
      }
    }
  }

  return time
};