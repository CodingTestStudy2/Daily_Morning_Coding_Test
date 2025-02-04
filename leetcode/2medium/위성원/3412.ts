const FLIPS = {
  a: "z",
  b: "y",
  c: "x",
  d: "w",
  e: "v",
  f: "u",
  g: "t",
  h: "s",
  i: "r",
  j: "q",
  k: "p",
  l: "o",
  m: "n",
  n: "m",
  o: "l",
  p: "k",
  q: "j",
  r: "i",
  s: "h",
  t: "g",
  u: "f",
  v: "e",
  w: "d",
  x: "c",
  y: "b",
  z: "a",
};

function calculateScore(s: string): number {
  const map = new Map<string, any>();

  // flip

  let answer = 0;
  for (let i = 0; i < s.length; i++) {
    const char = s[i];

    // step1: char의 mirror가 map에 있는지 확인
    const mirror = FLIPS[char];
    const mirrorValue = map.get(mirror);

    // step2: mirror가 있으면 짝 지어서 제거
    if (mirrorValue) {
      const { indices, pointer } = mirrorValue;

      // 사용되지 않은 index값이 있음
      if (typeof indices[pointer] !== "undefined") {
        answer += i - indices[pointer];
        const newI = [...indices];
        newI.shift();
        map.set(mirror, {
          indices: newI,
          pointer,
        });
        // 짝 지어진 char는 map에 추가할 필요 없음
        continue;
      }
    }

    const value = map.get(char);
    if (!value) {
      map.set(char, { indices: [i], pointer: 0 });
    } else {
      const newI = [...value.indices];
      newI.unshift(i);
      map.set(char, {
        ...value,
        indices: newI,
      });
    }
  }

  return answer;
}
