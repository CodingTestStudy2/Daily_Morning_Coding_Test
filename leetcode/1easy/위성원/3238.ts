function winningPlayerCount(n: number, pick: number[][]): number {
  // i 플레이어가 고른 color의 개수를 저장

  /* 
    i: {
        color: count
    }
  */
  const map = new Map<number, Record<number, number>>();

  let answer = 0;
  pick.forEach((p) => {
    const [i, color] = p;
    const obj = map.get(i);

    if (obj) {
      const count = obj[color];
      map.set(i, {
        ...obj,
        [color]: (count ?? 0) + 1,
      });
    } else {
      map.set(i, {
        [color]: 1,
      });
    }
  });

  let visited: boolean[] = [];

  for (const [i, values] of map) {
    const numberi = Number(i);

    if (visited[numberi]) {
      continue;
    }

    Object.values(values).forEach((v) => {
      if (Number(v) > numberi && !visited[numberi]) {
        answer++;
        visited[numberi] = true;
      }
    });
  }

  return answer;
}
